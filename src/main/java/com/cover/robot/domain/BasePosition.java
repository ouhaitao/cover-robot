package com.cover.robot.domain;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class BasePosition {
    private int x;
    private int y;

    public static BasePosition getInstance(String position){
        return JSON.parseObject(position,BasePosition.class);
    }
}
