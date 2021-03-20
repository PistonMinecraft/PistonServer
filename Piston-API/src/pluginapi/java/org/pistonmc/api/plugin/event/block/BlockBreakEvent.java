package org.pistonmc.api.plugin.event.block;

import org.pistonmc.api.plugin.entity.Entity;
import org.pistonmc.api.plugin.block.Block;
import org.pistonmc.api.common.event.Cancelable;

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