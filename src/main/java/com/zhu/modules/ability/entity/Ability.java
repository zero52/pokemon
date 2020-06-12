package com.zhu.modules.ability.entity;/*
2019/11/29
41586
*/

import java.io.Serializable;

public class Ability implements Serializable {

    private String id;
    private String name;
    private String effect;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
