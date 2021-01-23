package org.pistion.minecraft.entity;

public class Entity {
    //实体基类
    private String entityName;
    private String entityType;
    Entity(String entityName,String entityType){
        this.entityName = entityName;
        this.entityType = entityType;
    }
    public String getEntityName(){
        return entityName;
    }
    public void setEntityName(String entityName){
        this.entityName = entityName;
    }
    public String getEntityType(){
        return entityType;
    }
}
