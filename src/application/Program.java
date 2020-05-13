package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		System.out.print("entre com o nome do departamento: ");
		String departamentName = sc.nextLine();
		System.out.println("entre com as infromações do trabalhador: ");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		System.out.print("Nivel: ");
		String workerLevel = sc.nextLine();
		System.out.print("Salario base: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));
		
		System.out.print("quantos contratos esse trabalhador tem?: ");
		int c = sc.nextInt()+1;
		
		for(int i=1;i<c;i++) {
			System.out.printf("informações do contrato %d:%n ", i);
			System.out.print("Data (DD/MM/AAAA): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("valor por hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("duração em horas: ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate,valuePerHour,hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("diga o mês e o ano para calcular o salario(MM/AAAA): ");
		String mouthAndYear = sc.next();
		int mouth = Integer.parseInt(mouthAndYear.substring(0,2));
		int year = Integer.parseInt(mouthAndYear.substring(3));
		
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartament().getName());
		System.out.println("Ganhou: R$" + mouthAndYear + ": " + String.format("%.2f", worker.income(year,mouth)) + " Reais");
		
	sc.close();
	}

}
