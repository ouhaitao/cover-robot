package com.cover.robot.impl;

import com.cover.robot.domain.BasePosition;
import com.cover.robot.interfac.Processor;
import com.cover.robot.utils.ClickPositionUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;


@Service
public class SignProcessor implements Processor {
    //需要执行任务几次
    @Value("${process.sign.time}")
    private int countTime;

    //头像 位置
    @Value("${position.headPhoto}")
    private String headPhotoPositionStr;
    //签到 位置
    @Value("${position.sign}")
    private String signPositionStr;
    //后退 位置
    @Value("${position.back}")
    private String backPositionStr;

    @Override
    public boolean process() throws Exception {
        Robot robot = new Robot();
        robot.setAutoWaitForIdle(true);
        //开始流程
        for(int i = 0 ; i < countTime ;i ++){
            //点击头像
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(headPhotoPositionStr));
            //点击签到
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(signPositionStr));
            //点击两次返回
            for(int j = 0; j < 2 ; j++){
                ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(backPositionStr));
            }

        }


        return true;
    }
}
