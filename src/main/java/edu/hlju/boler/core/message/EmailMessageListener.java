package edu.hlju.boler.core.message;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import edu.hlju.boler.core.interfaces.IMessageHandler;
import edu.hlju.boler.pojo.po.Email;
import edu.hlju.boler.util.DateTimeUtil;

@Component
public class EmailMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(EmailMessageListener.class);

    @Resource
    private IMessageHandler emailMessageHandler;

    @Override
    public void onMessage(Message message) {
        try {
            // 将接收到的JSON字符串发序列化成为Email对象
            Object msg = JSON.parseObject(((TextMessage) message).getText(), Email.class);
            logger.info("[{}] {}", DateTimeUtil.now(), "Received a Email message.");
            emailMessageHandler.handle(msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
