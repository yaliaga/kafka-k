package pe.com.kafka.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.com.kafka.model.Purse;
import pe.com.kafka.service.KafkaProduce;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka-microservice")
public class KafkaController {
	private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
    private final KafkaProduce kafkaProduce;
    private final StreamBridge streamBridge;


    @GetMapping("/purse/{numberPhone}")
    public void send(@PathVariable String numberPhone) {
    	kafkaProduce.sendMessage(numberPhone);

    }

    @PostMapping("/purse")
    public void send(@RequestBody Purse purse) {
    	kafkaProduce.sendMessage(purse);
    }

    @RequestMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delegateToSupplier(@RequestBody String body) {
        logger.info("Sending" + body);
        streamBridge.send("toStream-out-1", body);
    }
}
