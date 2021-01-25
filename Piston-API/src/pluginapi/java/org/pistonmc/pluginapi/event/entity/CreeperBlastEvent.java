package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.CreeperBlastReason;
import org.pistonmc.pluginapi.entity.CreeperEntity;
import org.pistonmc.pluginapi.entity.Entity;
import org.pistonmc.pluginapi.entity.PlayerEntity;

public class CreeperBlastEvent extends EntityEvent {
    private CreeperBlastReason creeperBlastReason;
    private PlayerEntity detonatePlayer;
    private boolean damageOnly;
    public CreeperBlastEvent(CreeperBlastReason reason, PlayerEntity player, CreeperEntity triggerEntity, boolean isAsync) {
        super(triggerEntity, isAsync);
        creeperBlastReason = reason;
        detonatePlayer = player;
        damageOnly = false;
    }

    /**
     * 返回激怒苦力怕爆炸的玩家
     * 当creeperBlastReason为byFlint时 此参数可能为null
     * @return 激怒苦力怕爆炸的玩家
     */
    public PlayerEntity getDetonatePlayer() {
        return detonatePlayer;
    }
    /**
     * 返回爆炸原因
     * @return 爆炸原因
     */
    public CreeperBlastReason getCreeperBlastReason() {
        return creeperBlastReason;
    }
    /**
     * 设置是否只造成伤害不造成破坏
     * @param damageOnly
     */
    public void setDamageOnly(boolean damageOnly) {
        this.damageOnly = damageOnly;
    }

    /**
     * 返回是否只造成伤害不造成破坏
     * @return  是否只造成伤害不造成破坏
     */
    public boolean isDamageOnly() {
        return damageOnly;
    }
}
