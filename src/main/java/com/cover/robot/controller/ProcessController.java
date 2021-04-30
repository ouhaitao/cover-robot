package com.cover.robot.controller;

import com.cover.robot.config.ApplicationContextUtil;
import com.cover.robot.eunm.process.ProcessEnum;
import com.cover.robot.interfac.Processor;
import com.cover.robot.manager.ProcessorManger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProcessController {
    private final Logger logger = LoggerFactory.getLogger(ProcessController.class);

    @Autowired
    private ProcessorManger processorManger;

    @RequestMapping("/processStart")
    @ResponseBody
    public String processStart(String type) throws Exception{
        Thread.sleep(3000);
        if(!"all".equals(type)){
            logger.info("{} 任务开始。",type);
            Processor processor = processorManger.initProcessor(type);
            processor.process();
        }else {
            for(ProcessEnum processEnum: ProcessEnum.values()){
                logger.info("{} 任务开始。",processEnum.getType());
                Processor processor = processorManger.initProcessor(processEnum.getType());
                processor.process();
            }
        }

        return "ok";

    }

}
