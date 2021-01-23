package org.pistion.minecraft.event;

public class Event {
    //事件基类
    private boolean async;
    public Event(boolean isAsync){
        this.async = isAsync;
    }

    public boolean isAsync() {
        //返回事件是否异步
        return async;
    }
}
