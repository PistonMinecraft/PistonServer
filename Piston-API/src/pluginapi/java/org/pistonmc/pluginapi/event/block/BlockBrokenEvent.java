package org.pistonmc.pluginapi.event.block;

import org.pistonmc.pluginapi.block.Block;
import org.pistonmc.pluginapi.entity.Entity;

public class BlockBrokenEvent extends BlockEvent {
    private Entity brokenEntity;
    private boolean breakable;
    BlockBrokenEvent(Entity brokenEntity, Block block, boolean isAsync) {
        super(block, isAsync);
        this.brokenEntity = brokenEntity;
        this.breakable = true;
    }

    /**
     * 返回破坏方块的实体
     * @return  破坏方块的实体
     */
    public Entity getBrokenEntity() {
        return brokenEntity;
    }

    /**
     * 设置是否允许破坏
     * @param breakable
     */
    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

    /**
     * 返回是否允许破坏
     * @return  是否允许破坏
     */
    public boolean isBreakable() {
        return breakable;
    }
}
