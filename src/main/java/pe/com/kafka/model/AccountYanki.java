package pe.com.kafka.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountYanki {
	private String id;
    private String numberAccount;
	private double availableBalanceAccount;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateCreationAccount;
	private String statusAccount;
}

