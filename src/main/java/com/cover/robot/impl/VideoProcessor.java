package com.cover.robot.impl;

import com.cover.robot.domain.BasePosition;
import com.cover.robot.interfac.Processor;
import com.cover.robot.utils.ClickPositionUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;


@Service
public class VideoProcessor implements Processor {
    //需要执行任务几次
    @Value("${process.video.time}")
    private int countTime;

    //30s频道 位置
    @Value("${position.channel30s}")
    private String channel30sPositionStr;
    //第一个视频 位置
    @Value("${position.firstVideo}")
    private String firstVideoPositionStr;
    //后退 位置
    @Value("${position.back}")
    private String backPositionStr;
    //首页 位置
    @Value("${position.homePage}")
    private String homePagePositionStr;

    @Override
    public boolean process() throws Exception {
        Robot robot = new Robot();
        robot.setAutoWaitForIdle(true);
        //开始流程
        for(int i = 0 ; i < countTime ;i ++){
            //点击 30s频道
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(channel30sPositionStr));
            //点击 第一个视频
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(firstVideoPositionStr));
            //点击 后退
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(backPositionStr));
            //点击 首页
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(homePagePositionStr));
        }


        return true;
    }
}
