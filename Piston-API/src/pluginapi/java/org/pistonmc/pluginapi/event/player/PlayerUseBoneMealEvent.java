package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.block.Block;
import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerUseBoneMealEvent extends PlayerEvent {
    private Block targetBlock;
    public PlayerUseBoneMealEvent(Block targetBlock, PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
        this.targetBlock = targetBlock;
    }
    /**
     * 返回被使用骨粉的方块
     * @return 被使用骨粉的方块
     */
    public Block getTargetBlock() {
        return targetBlock;
    }
}
