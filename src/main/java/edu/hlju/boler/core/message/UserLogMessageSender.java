package edu.hlju.boler.core.message;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import edu.hlju.boler.core.interfaces.IMessageSender;
import edu.hlju.boler.util.DateTimeUtil;

@Component
public class UserLogMessageSender implements IMessageSender {
    private static final Logger logger = LoggerFactory.getLogger(UserLogMessageSender.class);

    @Resource
    private JmsTemplate userLogJmsTemplate;

    @Override
    public void send(Object obj) {
        userLogJmsTemplate.convertAndSend(JSON.toJSONString(obj));
        logger.info("[{}] {}", DateTimeUtil.now(), "UserLog message sent.");
    }

}
