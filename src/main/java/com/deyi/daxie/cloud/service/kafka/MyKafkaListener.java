package com.deyi.daxie.cloud.service.kafka;

import com.deyi.daxie.cloud.service.listener.LessonMsgService;
import com.deyi.daxie.cloud.service.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: cxb
 * @Description:
 * @DATE: Created in 2018/11/14
 */
@Slf4j
public class MyKafkaListener {
    @Autowired
    private LessonMsgService lessonMsgService;
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    /**
     * 发送聊天消息时的监听
     * @param record
     */
    @KafkaListener(topics = {"chatMessage"})
    public void listen(ConsumerRecord<?, ?> record) {
        log.info("chatMessage发送聊天消息监听："+record.value().toString());
        WebSocketServer chatWebsocket = new WebSocketServer();
        executorService.submit(() -> lessonMsgService.save(record.value().toString()));
        chatWebsocket.kafkaReceiveMsg(record.value().toString());
    }

    /**
     * 关闭连接时的监听
     * @param record
     */
    @KafkaListener(topics = {"closeWebsocket"})
    private void closeListener(ConsumerRecord<?, ?> record) {
        log.info("closeWebsocket关闭websocket连接监听："+record.value().toString());
        WebSocketServer chatWebsocket = new WebSocketServer();
        chatWebsocket.kafkaCloseWebsocket(record.value().toString());
    }
}
