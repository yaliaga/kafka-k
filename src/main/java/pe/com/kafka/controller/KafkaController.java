package pe.com.kafka.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;
import pe.com.kafka.message.Mailer;
import pe.com.kafka.model.RequestBootCoin;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comprarB")
public class KafkaController {
	
	
	  private final Mailer mailer;
	  

	    @PostMapping("/request")
	    public ResponseEntity<String> createPayment(@RequestBody RequestBootCoin requestBootCoin){
	        var value= this.mailer.sendRequestBootCoin(requestBootCoin);
	        return new ResponseEntity<>(value, HttpStatus.OK);
	    }

}
