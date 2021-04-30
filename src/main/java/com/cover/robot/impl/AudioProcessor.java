package com.cover.robot.impl;

import com.cover.robot.domain.BasePosition;
import com.cover.robot.interfac.Processor;
import com.cover.robot.utils.ClickPositionUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;


@Service
public class AudioProcessor implements Processor {
    //需要执行任务几次
    @Value("${process.audio.time}")
    private int countTime;

    //听封 位置
    @Value("${position.listenCover}")
    private String listenCoverPositionStr;
    //每日听单 位置
    @Value("${position.dailyListen}")
    private String dailyListenPositionStr;
    //首页 位置
    @Value("${position.homePage}")
    private String homePagePositionStr;
    //后退 位置
    @Value("${position.back}")
    private String backPositionStr;

    @Override
    public boolean process() throws Exception {
        Robot robot = new Robot();
        robot.setAutoWaitForIdle(true);
        //开始流程
        for(int i = 0 ; i < countTime ;i ++){
            //点击听封
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(listenCoverPositionStr));
            //点击原创精品栏目
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(dailyListenPositionStr));
            //点击音频
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance("{\"x\":80,\"y\":330}"));
            //点击返回
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(backPositionStr));
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(backPositionStr));
            //点击首页
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(homePagePositionStr));
        }


        return true;
    }
}
