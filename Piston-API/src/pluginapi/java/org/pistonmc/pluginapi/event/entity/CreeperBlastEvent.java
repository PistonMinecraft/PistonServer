package org.pistonmc.pluginapi.event.entity;

import org.pistonmc.pluginapi.entity.CreeperEntity;
import org.pistonmc.pluginapi.entity.PlayerEntity;

public class CreeperBlastEvent extends EntityEvent {
    private final CreeperBlastReason reason;
    private final PlayerEntity who;
    private boolean damageOnly;
    public CreeperBlastEvent(CreeperBlastReason reason, PlayerEntity who, CreeperEntity creeper, boolean async) {
        super(creeper, async);
        this.reason = reason;
        this.who = who;
        damageOnly = false;
    }

    /**
     * 返回激怒苦力怕爆炸的玩家
     * 当{@code reason}为{@link CreeperBlastReason#FLINT}时，此参数可能为null
     * @return 激怒苦力怕爆炸的玩家
     */
    public PlayerEntity getDetonatePlayer() {
        return who;
    }
    /**
     * 返回爆炸原因
     * @return 爆炸原因
     */
    public CreeperBlastReason getReason() {
        return reason;
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

    public enum CreeperBlastReason {
        FLINT,
        PLAYER
    }
}
