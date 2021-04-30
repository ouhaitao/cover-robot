package com.cover.robot.impl;

import com.cover.robot.interfac.Processor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;


@Service
public class VideoBrokeNewsProcessor implements Processor {
    //需要执行任务几次
    @Value("${process.videoBrokeNews.time}")
    private int countTime;

    @Override
    public boolean process() throws Exception {
        Robot robot = new Robot();
        robot.setAutoWaitForIdle(true);
        //开始流程
        // TODO: 2021/4/23 hkc 流程待确认
        for(int i = 0 ; i < countTime ;i ++){

        }


        return true;
    }
}
