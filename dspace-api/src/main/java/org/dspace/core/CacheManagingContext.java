package org.dspace.core;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class CacheManagingContext extends Context {
    private static final Logger log = Logger.getLogger(CacheManagingContext.class);
    
    ArrayList<ReloadableEntity<?>> reloadableEntityStack = new ArrayList<>();
    
    /*
     * During recursive hierarchy traversal, push an item on to the stack.
     * If the object cache is cleared, these items should be restored.
     */
    public void push(ReloadableEntity<?> entity){
        reloadableEntityStack.add(entity);
    }
    
    /*
     * Pop and item off of the reloadable entity cache
     */
    public ReloadableEntity<?> pop(){
        if (reloadableEntityStack.isEmpty()) {
            return null;
        }
        return reloadableEntityStack.remove(reloadableEntityStack.size() - 1);
    }

    /*
     * Pop and item off of the reloadable entity cache
     */
    public ReloadableEntity<?> currentEntity(){
        if (reloadableEntityStack.isEmpty()) {
            return null;
        }
        return reloadableEntityStack.get(reloadableEntityStack.size() - 1);
    }

    
    /*
     * Clear the reloadable entity stack
     */
    public void clearReloadableCache() {
        reloadableEntityStack.clear();
    }
    
    /**
     * Clear the cache of all object that have been read from the database so far. This will also free up
     * (heap space) memory. You should use this method when processing a large number of records.
     *
     * <b>WARNING: After calling this method all previously fetched entities are "detached" (pending
     * changes are not tracked anymore). You have to reload all entities you still want to work with
     * manually after this method call (see {@link Context#reloadEntity(ReloadableEntity)}).</b>
     *
     * This method will take care of reloading the current user.
     *
     * @throws SQLException When clearing the entity cache fails
     */
    @Override public void clearCache() throws SQLException {
        if(log.isDebugEnabled()) {
            log.debug("Cache size before clear cache is " + getCacheSize());
        }

        this.getDBConnection().clearCache();

        reloadContextBoundEntities();
    }

    /**
     * Reload all entities related to this context.
     * 
     * Items to be reloaded should be pushed on to the stack
     * 
     * @throws SQLException When reloading one of the entities fails.
     */
    protected void reloadContextBoundEntities() throws SQLException {
        super.reloadContextBoundEntities();
        for(int i=0; i<reloadableEntityStack.size(); i++) {
            ReloadableEntity<?> ent = reloadableEntityStack.get(i);
            System.out.println("Reloading "+ent.getID());
            log.debug("Reloading entity: " + ent.getID());
            reloadEntity(ent);
            reloadableEntityStack.set(i, this.reloadEntity(ent));
        }
    }
}
