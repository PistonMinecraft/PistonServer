package org.pistonmc.pluginapi.event.block;

import org.pistonmc.pluginapi.block.Block;
import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.event.Cancelable;

public class BlockBreakEvent extends BlockEvent implements Cancelable {
    private final Entity who;
    private boolean cancelled;

    public BlockBreakEvent(Block block, Entity who) {
        super(block);
        this.who = who;
    }

    /**
     * 返回破坏方块的实体
     * @return  破坏方块的实体
     */
    public Entity getBreaker() {
        return who;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
