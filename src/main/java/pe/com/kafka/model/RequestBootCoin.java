package pe.com.kafka.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBootCoin {
    private double amount;
    private String payMode;
    private String number;
}
