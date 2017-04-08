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
import edu.hlju.boler.pojo.po.UserLog;
import edu.hlju.boler.util.DateTimeUtil;

@Component
public class UserLogMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(UserLogMessageListener.class);

    @Resource
    private IMessageHandler userLogMessageHandler;

    @Override
    public void onMessage(Message message) {
        try {
            // 将接收到的JSON字符串发序列化成为UserLog对象
            Object msg = JSON.parseObject(((TextMessage) message).getText(), UserLog.class);
            logger.info("[{}] {}", DateTimeUtil.now(), "Received a UserLog message.");
            userLogMessageHandler.handle(msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
