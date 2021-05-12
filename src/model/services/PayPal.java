package model.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

public class PayPal implements PaymentServices {
	double interests = 0.01;
	double fee = 0.02;		
	double ContractValue;
	double installments;
	
	static List<Double> MonthInstallments = new ArrayList<Double>();

	public PayPal(double contractValue, double installments) {
		ContractValue = contractValue;
		this.installments = installments;
	}

	@Override
	public List<Double> interests(double ContractValue, int Installments) {

		double Installment = ContractValue / Installments;	
		
		for(int i = 1; i <= Installments; i++) {			
			double temp = (Installment + (Installment * interests * i)) + ((Installment + (Installment * interests * i)) * fee);	
			MonthInstallments.add(temp);
		}
		
		return MonthInstallments;
	}

	public static List<Double> getMonthInstallments() {
		return MonthInstallments;
	}

	public void setMonthInstallments(List<Double> monthInstallments) {
		MonthInstallments = monthInstallments;
	}
}
