package com.cover.robot.impl;

import com.cover.robot.domain.BasePosition;
import com.cover.robot.interfac.Processor;
import com.cover.robot.utils.ClickPositionUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.event.KeyEvent;


@Service
public class BrokeNewsOtherProcessor implements Processor {
    //需要执行任务几次
    @Value("${process.brokeNewsOther.time}")
    private int countTime;

    //青椒频道 位置
    @Value("${position.qjChannel}")
    private String qjChannelPositionStr;
    @Value("${position.subject}")
    private String subjectPositionStr;
    //关注按钮 位置
    @Value("${position.focus}")
    private String focusPositionStr;
    //圈子 位置
    @Value("${position.circle}")
    private String circlePositionStr;
    //加入按钮 位置
    @Value("${position.jion}")
    private String jionPositionStr;
    //后退 位置
    @Value("${position.back}")
    private String backPositionStr;

    @Override
    public boolean process() throws Exception {
        Robot robot = new Robot();
        robot.setAutoWaitForIdle(true);
        //开始流程
        for(int i = 0 ; i < countTime ;i ++){
            //点击青椒频道
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(qjChannelPositionStr));
            // 点击话题
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(subjectPositionStr));
            //两次点击关注按钮（关注、取消关注）
            for(int j = 0; j < 2 ; j++){
                ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(focusPositionStr));
            }
            //点击返回
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(backPositionStr));
            //点击圈子
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(circlePositionStr));
            //两次点击加入（加入、退出）
            for(int j = 0; j < 2 ; j++){
                ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(jionPositionStr));
            }
            //点击返回
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(backPositionStr));
//            发动态
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance("{\"x\":500,\"y\":900}"));
//            选中输入框
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance("{\"x\":200,\"y\":200}"));
//            文字
            int[] keyCode = {KeyEvent.VK_D, KeyEvent.VK_O, KeyEvent.VK_N,
                KeyEvent.VK_G, KeyEvent.VK_T, KeyEvent.VK_A, KeyEvent.VK_I, KeyEvent.VK_SPACE};
            ClickPositionUtil.writeA2Z(robot, keyCode);
//            发送
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance("{\"x\":500,\"y\":100}"));
    
            // 点击中国频道使tab位于正确为止
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance("{\"x\":20,\"y\":180}"));
        }


        return true;
    }
}
