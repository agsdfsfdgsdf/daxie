package com.deyi.daxie.cloud.service.kafka;


import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: yxl
 * @Description: Kafka消费者
 * @DATE: Created in 2018/11/14
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setPollTimeout(1500);
        return factory;
    }

    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }


    public Map<String, Object> consumerConfigs() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("bootstrap.servers", "10.2.2.162:9092");
        //properties.put("group.id", "192.168.150.139");
        properties.put("group.id", getIPAddress()); //获取服务器Ip作为groupId
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return properties;
    }

    public String getIPAddress() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            if (address != null && StringUtils.isNotBlank(address.getHostAddress())) {
                return address.getHostAddress();
            }
        }catch (UnknownHostException e) {
            return UUID.randomUUID().toString().replace("-","");
        }
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 自定义监听
     */
    @Bean
    public MyKafkaListener listener() {
        return new MyKafkaListener();
    }
}
