package pe.com.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purse {
	private String id;
    private String numberCard;
    private String numberPhone;
    private String imei;
    private String document;
    private String email;
    private int status; 
}
