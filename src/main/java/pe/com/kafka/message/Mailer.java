package pe.com.kafka.message;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import pe.com.kafka.model.RequestBootCoin;
import pe.com.kafka.utils.Topic;


@Service
public class Mailer {
	private static final Logger logger= LoggerFactory.getLogger(Mailer.class);


    private KafkaTemplate<String, RequestBootCoin> kafkaTemplate;

    public Mailer(KafkaTemplate<String, RequestBootCoin> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendRequestBootCoin(RequestBootCoin value) {
        kafkaTemplate.send(Topic.REQUEST_BUY,value);
        logger.info("Messages successfully pushed on topic: " + Topic.REQUEST_BUY);
        return "Sending BootCoin purchase request ->";
    }


}
