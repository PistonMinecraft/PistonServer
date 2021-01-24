package org.pistonmc.pluginapi.event.player;

import org.pistonmc.pluginapi.block.Chest;
import org.pistonmc.pluginapi.entity.PlayerEntity;

public class PlayerOpenChestEvent extends PlayerEvent {
    private Chest chest;
    private boolean openable;
    public PlayerOpenChestEvent(Chest chest, PlayerEntity triggerPlayer, boolean isAsync) {
        super(triggerPlayer, isAsync);
        this.chest = chest;
        openable = true;
    }

    /**
     * 返回是否允许玩家打开
     * @return  是否允许玩家打开
     */
    public boolean isOpenable() {
        return openable;
    }

    /**
     * 设置是否允许玩家打开
     * @param openable
     */
    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    /**
     * 返回被打开的箱子
     * @return  被打开的箱子
     */
    public Chest getChest() {
        return chest;
    }
}
