package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		// para ser possivel receber um tipo Date tem que instaciar SimpleDateFormat passando a mascara "dd/MM/yyyy"
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel) , baseSalary, new Department(departmentName));
		//instaciado uma variavel worker do tipo Worker recebendo do dados
		//  o valor workerName foi digitado, uma instaciação de WorkerLevel com o valor workerLevel digitado, o valor baseSalary também digitado 
		//e associado a esse objeto, temos outro objeto do tipo Department e o nome desse departmentName foi digitado
		
		//teste de impressão dos dados
		//System.out.println();
		//System.out.println(worker);
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");   //para receber um tipo Date, é necessário instaciar no inicio o SimpleDateFormat
			Date contractDate = sdf.parse(sc.next());  //"sdf.parse"converte o dado recebido do tipo String para tipo Date 
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);   // instaciação do contrato
			worker.addContract(contract);   //associando o contrato com o trabalhador
		}
		
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String  monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));//"Integer.parseInt" converte o string para inteiro
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month))); // "String.format" possibilitar a formatação para 2 digitos no double.		
		
		sc.close();

	}

}
