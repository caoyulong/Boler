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
public class EmailMessageSender implements IMessageSender {
    private static final Logger logger = LoggerFactory.getLogger(EmailMessageSender.class);

    @Resource
    private JmsTemplate emailJmsTemplate;

    @Override
    public void send(Object obj) {
        emailJmsTemplate.convertAndSend(JSON.toJSONString(obj));
        logger.info("[{}] {}", DateTimeUtil.now(), "Email message sent.");
    }

}
