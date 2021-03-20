package org.pistonmc.api.common.event;

/**
 * 此类表示一个可取消的{@link Event}
 * <br>
 * This class represents a cancelable {@link Event}
 */
public interface Cancelable {
    /**
     * 返回此事件是否被取消
     * <br>
     * Returns whether this event is cancelled or not
     * @return 此事件是否被取消<br>If this event is cancelled
     */
    boolean isCancelled();

    /**
     * 设置此事件是否已经取消
     * <br>
     * Sets whether this event is cancelled or not
     * @param cancelled 此事件是否被取消<br>If this event is cancelled
     */
    void setCancelled(boolean cancelled);
}