package model.services;

import java.util.List;

public interface PaymentServices {
	
	List<Double> interests (double ContractValue, int Installments);

}
