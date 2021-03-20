package org.pistonmc.api.plugin.event.entity;

import org.pistonmc.api.plugin.entity.CreeperEntity;

public class CreeperBlastEvent extends EntityEvent {
    private final CreeperBlastReason reason;
    private boolean damageOnly;

    public CreeperBlastEvent(CreeperEntity creeper, CreeperBlastReason reason) {
        super(creeper);
        this.reason = reason;
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