package com.cover.robot.impl;

import com.cover.robot.interfac.Processor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;


@Service
@Deprecated
public class ShareProcessor implements Processor {
    //需要执行任务几次
    @Value("${process.share.time}")
    private int countTime;

    @Override
    public boolean process() throws Exception {
        Robot robot = new Robot();
        robot.setAutoWaitForIdle(true);
        //开始流程
        for(int i = 0 ; i < countTime ;i ++){

        }


        return true;
    }
}
