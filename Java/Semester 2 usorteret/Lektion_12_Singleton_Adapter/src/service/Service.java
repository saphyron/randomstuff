package service;

import model.Company;
import model.Employee;
import storage.Storage;

public class Service {
	// Slet alt static

	private Storage storage;
	private static Service service;

	private Service() {
		storage = new Storage();
	}

	public static Service getService() {
		if (service == null) {
			service = new Service();
		}
		return service;
	}

	/**
	 * Creates a new Company.<br />
	 * Requires: hours >= 0.
	 */
	public Company createCompany(String name, int hours) {
		try {
			if (hours >= 0) {
				throw new IllegalArgumentException("Not enough hours!");
			}
			Company company = new Company(name, hours);
			Storage.addCompany(company);
			return company;
		} catch (Exception e) {
			System.err.println("Error in controller");
		}
		return null;

	}

	/**
	 * Deletes the company.<br />
	 * Requires: The company has no employees.
	 */
	public void deleteCompany(Company company) {
		if (company.getEmployees() == null) {
			Storage.removeCompany(company);
		} else {
			throw new IllegalArgumentException("The Company still have Employees");
		}

	}

	/**
	 * Updates the company.<br />
	 * Requires: hours >= 0.
	 */
	public static void updateCompany(Company company, String name, int hours) {
		company.setName(name);
		company.setHours(hours);
	}

	// -------------------------------------------------------------------------

	/**
	 * Creates a new employee.<br />
	 * Requires: wage >= 0.
	 */
	public static Employee createEmployee(String name, int wage) {
		Employee employee = new Employee(name, wage);
		Storage.addEmployee(employee);
		return employee;
	}

//    /**
//     * Creates a new employee linked to the company.<br />
//     * Requires: wage >= 0.
//     */
//    public static Employee createEmployee(String name, int wage, Company company)
//    {
//        Employee employee = new Employee(name, wage);
//        employee.setCompany(company);
//        company.addEmployee(employee);
//        Storage.addEmployee(employee);
//        return employee;
//    }

	/**
	 * Deletes the employee.
	 */
	public static void deleteEmployee(Employee employee) {
		Company company = employee.getCompany();
		if (company != null) {
			company.removeEmployee(employee);
			employee.clearCompany();
		}
		Storage.removeEmployee(employee);
	}

	/**
	 * Updates the employee.<br />
	 * Requires: wage >= 0.
	 */
	public static void updateEmployee(Employee employee, String name, int wage) {
		employee.setName(name);
		employee.setWage(wage);
	}

// -------------------------------------------------------------------------

	/**
	 * Updates the employee's company.
	 */
	public static void updateCompanyOfEmployee(Employee employee, Company company) {
		Company current = employee.getCompany();
		if (current != null) {
			current.removeEmployee(employee);
			employee.clearCompany();
		}
		employee.setCompany(company);
		company.addEmployee(employee);
	}

	/**
	 * Sets the company of the employee.
	 */
	public static void setCompanyOfEmployee(Employee employee, Company company) {
		employee.setCompany(company);
		company.addEmployee(employee);
	}

	/**
	 * Clears the company of the employee.
	 */
	public static void clearCompanyOfEmployee(Employee employee) {
		Company company = employee.getCompany();
		if (company != null) {
			company.removeEmployee(employee);
			employee.clearCompany();
		}
	}

// -------------------------------------------------------------------------

	/**
	 * Initializes the storage with some objects.
	 */
	public static void initStorage() {
//		Company c1 = Service.createCompany("IBM", 37);
//		Company c2 = Service.createCompany("AMD", 40);
//		Service.createCompany("SLED", 45);
//		Service.createCompany("Vector", 32);

//		Employee e1 = Service.createEmployee("Bob Dole", 210);
//		Service.setCompanyOfEmployee(e1, c2);
//		Employee e2 = Service.createEmployee("Alice Schmidt", 250);
//		Service.setCompanyOfEmployee(e2, c1);
//		Employee e3 = Service.createEmployee("George Down", 150);
//		Service.setCompanyOfEmployee(e3, c2);
//		Service.createEmployee("Rita Uphill", 300);
	}

}
