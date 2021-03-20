package org.pistonmc.api.plugin.event.block;

import org.pistonmc.api.common.event.Event;
import org.pistonmc.api.plugin.block.Block;

public abstract class BlockEvent extends Event {
    private final Block block;

    public BlockEvent(Block block) {
        this.block = block;
    }

    public BlockEvent(Block block, boolean isAsync) {
        super(isAsync);
        this.block = block;
    }

    /**
     * 返回触发事件的方块
     * @return  触发事件的方块
     */
    public Block getBlock() {
        return block;
    }
}