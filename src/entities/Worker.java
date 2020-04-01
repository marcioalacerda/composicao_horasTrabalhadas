package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<HourContract>();
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract (HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract (HourContract contract) {
		contracts.remove(contract);
	}
	public double income (int year, int month) {
		double sum = baseSalary; //soma inicia com o valor do salário básico do funcionário
		Calendar cal = Calendar.getInstance(); // instaciação da classe Calendar (manupulador de datas)
		for (HourContract c : contracts) { //para cada contrato c na lista contacts faça
			cal.setTime(c.getDate());// a variavel cal esta recebendo a data do contrato c
			int c_year = cal.get(Calendar.YEAR); // variavel para receber o ano extraído da variável cal.setTime) 
			int c_month = 1 + cal.get(Calendar.MONTH); //variavel para receber o mês extraído da variável cal.setTime
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
	/* //teste de impressão dos dados
	public String toString() {
		return name +", " + level + ", " + baseSalary + ", " + getDepartment().getName();
	}*/

}
