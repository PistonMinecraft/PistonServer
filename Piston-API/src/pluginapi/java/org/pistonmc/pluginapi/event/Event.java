package org.pistonmc.pluginapi.event;

/**
 * 此类表示一个{@code 事件}。
 * <br><br>
 * This class represents an {@code Event}.
 */
public abstract class Event {
    private final boolean async;
    /**
     * 构造一个同步{@code 事件}
     * <br><br>
     * Constructs a sync {@code Event}
     */
    public Event() {
        this(false);
    }

    /**
     * 构造一个{@code 事件}
     * <br><br>
     * Constructs a {@code Event}
     * @param async 此事件是否为异步事件<br><br>Whether this event is async
     */
    public Event(boolean async) {
        this.async = async;
    }

    /**
     * 获取此事件是否异步
     * <br><br>
     * Get whether this event is async
     * @return 此事件是否异步<br><br>Whether this event is async
     */
    public boolean isAsync() {
        return async;
    }
}
