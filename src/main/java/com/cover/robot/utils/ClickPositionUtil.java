package com.cover.robot.utils;

import com.cover.robot.domain.BasePosition;
import lombok.Data;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.Random;

@Data
public class ClickPositionUtil {
    private final static int DEFAULT_TIME = 3000;
    
    public static void clickPosition(Robot robot, BasePosition position) {
        clickPosition(robot, position, DEFAULT_TIME);
    }
    
    public static void clickPosition(Robot robot, BasePosition position, int sleepTime) {
        robot.mouseMove(position.getX(), position.getY());
        //延时30毫秒
        robot.delay(30);
        // 按下鼠标左键
        robot.mousePress(InputEvent.BUTTON1_MASK);
        // 延时30毫秒
        robot.delay(30);
        // 释放鼠标左键（按下后必须要释放, 一次点击操作包含了按下和释放）
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        //给app响应时间，延时3s
        robot.delay(sleepTime);
    }
    
    //keyCode对应的A-Z，就是ascii码数值(65-90)
    public static void writeA2Z(Robot robot, int[] keyCode) {
        for (int i = 0; i < keyCode.length; i++) {
            robot.keyPress(keyCode[i]);
            robot.delay(30);
            robot.keyRelease(keyCode[i]);
            robot.delay(500);
        }
    }
}
