package org.pistion.minecraft.event.player;

import org.pistion.minecraft.entity.PlayerEntity;
import org.pistion.minecraft.event.Event;

public class PlayerEvent extends Event {
    //玩家事件基类
    private PlayerEntity player;
    public PlayerEvent(PlayerEntity player, boolean isAsync) {
        super(isAsync);
        this.player=player;
    }
    public PlayerEntity getPlayer(){
        //返回触发该事件的玩家实体
        return player;
    }
}
