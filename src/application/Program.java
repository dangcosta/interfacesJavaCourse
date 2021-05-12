package application;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ContractInformation;
import model.services.PayPal;
import model.services.PaymentServices;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Contract Data");
		
		System.out.println("Number:");
		int Number = sc.nextInt();

		System.out.println("Date:");
		String date = sc.next();
		
		System.out.println("Contract Value:");
		double ContractValue = sc.nextDouble();
		
		System.out.println("Number of installments:");
		int Installments = sc.nextInt();
		
		ContractInformation contract = new ContractInformation(Number, ContractValue, Installments, date, new PayPal(ContractValue, Installments));
		contract.MonthInstallment();
		
		
		// Ajeitar datas, ajeitar imprimir o resultado.
				
		sc.close();
	}	
}
