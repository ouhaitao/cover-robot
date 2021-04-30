package com.cover.robot.impl;

import com.cover.robot.domain.BasePosition;
import com.cover.robot.interfac.Processor;
import com.cover.robot.utils.ClickPositionUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;


@Service
public class LiveDetailProcessor implements Processor {
    //需要执行任务几次
    @Value("${process.liveDetail.time}")
    private int countTime;

    //直播tab 位置
    @Value("${position.liveTab}")
    private String liveTabPositionStr;
    //直播tab中banner 位置
    @Value("${position.liveBanner}")
    private String liveBannerPositionStr;
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
            //点击 直播tab
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(liveTabPositionStr));
            //点击 直播tab中banner
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(liveBannerPositionStr));
            //点击 后退
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(backPositionStr));
            //点击 首页
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(homePagePositionStr));
        }


        return true;
    }
}
