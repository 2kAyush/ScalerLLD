package com.example.snakeandladder.models;

import java.util.HashMap;
import java.util.List;

public class Board {
    private int size;
    private HashMap<Integer, ForeignEntity> foreignEntityMap;
    Board(int size) {
        this.size = size;
        this.foreignEntityMap = new HashMap<>();
    }
    public void addForeignEntities(List<ForeignEntity> foreignEntities) {
        for(ForeignEntity foreignEntity:foreignEntities){
            foreignEntityMap.put(foreignEntity.getFrom(), foreignEntity);
        }
    }
    public int getSize() {
        return size;
    }

    public HashMap<Integer, ForeignEntity> getForeignEntityMap() {
        return foreignEntityMap;
    }
}
