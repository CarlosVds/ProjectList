package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("How many employee will be registered? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Employee # " + (i + 1));
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));

			System.out.print("Enter the employee id that will have salary increase? ");
			int idEmployee = sc.nextInt();
			Employee result = list.stream().filter(x -> x.getId() == idEmployee).findFirst().orElse(null);

			if (result == null) {
				System.out.println("This id does not exist");
			} else {
				System.out.print("Enter the percenter: ");
				double percenter = sc.nextDouble();
				result.increaseSalary(percenter);
			}

			System.out.println();
			System.out.println("List of employees:");
			for (Employee obj : list) {
				System.out.println(obj);
			}

			sc.close();
		}
	}
}
