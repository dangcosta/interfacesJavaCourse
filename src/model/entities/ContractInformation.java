package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.services.PayPal;
import model.services.PaymentServices;

public class ContractInformation {
	
	private int Number;
	private Date date;
	private double ContractValue;
	private int Installments;
	PaymentServices paymentServices;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
	
	
	public ContractInformation(int number, double contractValue, int installments, String date, PaymentServices paymentServices) throws ParseException {		
		Number = number;
		this.date = sdf.parse(date);
		ContractValue = contractValue;
		Installments = installments;
		this.paymentServices = paymentServices;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getContractValue() {
		return ContractValue;
	}

	public void setContractValue(double contractValue) {
		ContractValue = contractValue;
	}

	public int getInstallments() {
		return Installments;
	}

	public void setInstallments(int installments) {
		Installments = installments;
	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
	
	public void MonthInstallment(){		
		System.out.println("Number: " + Number);
		System.out.println("Date of the Contract: " + sdf.format(date));		
		System.out.println("Contract Value: " + ContractValue);
		
		//Embora eu pudesse colocar a variável aqui em vez do tamanho da List, eu optei por colocar o tamanho da List como um "double check" de que estava do tamanho correto (correspondendo ao número de installments)
		System.out.println("Installments: " + paymentServices.interests(ContractValue, Installments).size());
		
		for (int i = 1; i <= Installments; i++) {
			Date dueDate = addMonths(date, i);
			System.out.println(sdf.format(dueDate) + " - " + paymentServices.interests(ContractValue, Installments).get(i));
		}
		
	}	
}
