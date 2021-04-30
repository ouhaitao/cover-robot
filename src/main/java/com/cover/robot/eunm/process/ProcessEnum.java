package com.cover.robot.eunm.process;

import lombok.Data;
import org.springframework.util.StringUtils;


public enum ProcessEnum {
//    合计 20+15+18+12+20=85
    
    //签到 1*2=2
    SIGN("sign","signProcessor"),
    //看视屏 4*5=20
    VIDEO("video", "videoProcessor"),
    //文章详情（看新闻、评论、收藏、分享）5*3=15
    NEWS_DETAIL("newsDetail", "newsDetailProcessor"),
    //直播详情 3*6=18
    LIVE_DETAIL("liveDetail", "liveDetailProcessor"),
    //音频 3*4=12
    AUDIO("audio", "audioProcessor"),
//    //分享
//    SHARE("share", "shareProcessor"),
//    //报料视频
//    //todo hkc 确认这里应该在哪里?是否能跟青椒合并
//    VIDEO_BROKENEWS("videoBrokeNews", "videoBrokeNewsProcessor"),
    //青椒（加入圈子、关注）5*4=20
    BROKENEWS_OTHER("brokeNewsOther", "brokeNewsOtherProcessor");

    private String type;
    private String clazzName;

    ProcessEnum(String type, String clazzName) {
        this.type = type;
        this.clazzName = clazzName;
    }

    public static ProcessEnum getEnumByType(String processType){
        if(StringUtils.isEmpty(processType)){
            throw new IllegalArgumentException("参数不能为空");
        }

        for(ProcessEnum processEnum : ProcessEnum.values()){
            if(processEnum.getType().equalsIgnoreCase(processType)){
                return processEnum;
            }
        }

        throw new IllegalArgumentException("未找到类型："+processType);
    }

    public String getType() {
        return type;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }
}
