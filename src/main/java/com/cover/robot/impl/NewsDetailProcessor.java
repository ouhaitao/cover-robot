package com.cover.robot.impl;

import com.cover.robot.domain.BasePosition;
import com.cover.robot.interfac.Processor;
import com.cover.robot.utils.ClickPositionUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.event.KeyEvent;


@Service
public class NewsDetailProcessor implements Processor {
    //需要执行任务几次
    @Value("${process.newsDetail.time}")
    private int countTime;

    //第一个频道tab 位置
    @Value("${position.firstChannelTab}")
    private String firstChannelTabPositionStr;
    //第一篇新闻 位置
    @Value("${position.firstNews}")
    private String firstNewsPositionStr;
    //收藏按钮 位置
    @Value("${position.collect}")
    private String collectPositionStr;
    //分享按钮 位置
    @Value("${position.share}")
    private String sharePositionStr;
    //微信按钮 位置
    @Value("${position.wechat}")
    private String wechatPositionStr;
    //微信关闭按钮 位置
    @Value("${position.wechatClose}")
    private String wechatClosePositionStr;
    //评论输入框 位置
    @Value("${position.discussWrite}")
    private String discussWritePositionStr;
    //评论发送按钮 位置
    @Value("${position.discussSend}")
    private String discussSendPositionStr;
    //后退 位置
    @Value("${position.back}")
    private String backPositionStr;

    @Override
    public boolean process() throws Exception {
        Robot robot = new Robot();
        robot.setAutoWaitForIdle(true);
        //开始流程
        for(int i = 0 ; i < countTime ;i ++){
            //点击 第一个频道
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(firstChannelTabPositionStr));
            //点击 第一个新闻
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(firstNewsPositionStr));
            //两次点击 收藏
            for(int j = 0; j < 2 ; j++){
                ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(collectPositionStr));
            }
            //点击 评论输入框
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(discussWritePositionStr));
            //输入文字 好文章
            int[] keyCode = {KeyEvent.VK_H, KeyEvent.VK_A, KeyEvent.VK_O,
                KeyEvent.VK_W, KeyEvent.VK_E, KeyEvent.VK_N,
                KeyEvent.VK_Z, KeyEvent.VK_H, KeyEvent.VK_A, KeyEvent.VK_N, KeyEvent.VK_G, KeyEvent.VK_SPACE};
            ClickPositionUtil.writeA2Z(robot, keyCode);
            //点击 评论发送
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(discussSendPositionStr));
            //点击 后退
            ClickPositionUtil.clickPosition(robot, BasePosition.getInstance(backPositionStr));
        }


        return true;
    }
}
