package pe.com.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import pe.com.kafka.model.Purse;
import pe.com.kafka.topic.Topic;

@Service
public class KafkaProduce {
	private static final Logger logger= LoggerFactory.getLogger(KafkaProduce.class);


    @Autowired
    public KafkaTemplate<String, String> stringKafkaTemplate;
    @Autowired
    public KafkaTemplate<String, Purse> purseKafkaTemplate;




    public void sendMessage(String value) {
        ListenableFuture<SendResult<String,String>> future = stringKafkaTemplate.send(Topic.INS_PURSE, value);

        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Messages failed to push on topic: " + Topic.INS_PURSE);
            }
            @Override
            public void onSuccess(Object result) {
                logger.info("Messages successfully pushed on topic: "+Topic.INS_PURSE);
            }
        });
    }

    public void sendMessage(Purse value) {
        ListenableFuture<SendResult<String,Purse>> future = purseKafkaTemplate.send(Topic.INS_PURSE_JSON, value);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Messages failed to push on topic: "+ Topic.INS_PURSE_JSON);
            }
            @Override
            public void onSuccess(Object result) {

                logger.info("messages were not sent: "+Topic.INS_PURSE_JSON);
            }
        });
    }
}
