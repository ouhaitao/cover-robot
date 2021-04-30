package com.cover.robot.manager;

import com.cover.robot.config.ApplicationContextUtil;
import com.cover.robot.eunm.process.ProcessEnum;
import com.cover.robot.interfac.Processor;
import org.springframework.stereotype.Component;

@Component
public class ProcessorManger {

    public Processor initProcessor(String processType){
        ProcessEnum processTypeEnum = ProcessEnum.getEnumByType(processType);
        String clazzName = processTypeEnum.getClazzName();
        return ApplicationContextUtil.getBean(clazzName,Processor.class);
//        switch (processTypeEnum){
//            case UP_LEVEL:
//                break;
//            case JOIN_FACTION:
//                break;
//            case IMPEDIMENTA:
//                break;
//            case TRANS_ROLE:
//                break;
//            case TRANS_ACCOUNT:
//                break;
//        }
    }





}
