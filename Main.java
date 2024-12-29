import java.util.List;
import java.util.Scanner;

public class Main {
    private static EmployeeManager manager = new EmployeeManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n\n----Welcome to Employee Management System---");
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getValidIntInput("Please enter your choice: ");

            if (choice == 1) {
                addEmployee();
            }

            else if (choice == 2) {
                removeEmployee();
            }

            else if (choice == 3) {
                updateEmployee();
            }

            else if (choice == 4) {
                listEmployees();
            } else if (choice == 5) {
                running = false;
            }
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thanks for using the app, Bye!");
        scanner.close();

    }

    public static void printMenu() {
        System.out.println("\nPlease choose an option.");
        System.out.println("1 To add an Employee");
        System.out.println("2 To remove an Employee");
        System.out.println("3 To update Employee ");
        System.out.println("4 To list all Employees");
        System.out.println("5 To Exit");
    }

    public static int getValidIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static double getValidDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid number");
            }
        }
    }

    public static void addEmployee() {
        try {
            System.out.println("\n---Add New Employee---");
            int id = getValidIntInput("Enter new Employee ID: ");

            System.out.print("Enter new Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new Employee Department: ");
            String dept = scanner.nextLine();

            double sal = getValidDoubleInput("Enter new Employee Salary: ");

            Employee emp = new Employee(id, name, dept, sal);
            if (manager.addEmployee(emp)) {
                System.out.println("New Employee added successfully.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void removeEmployee() {
        System.out.println("\n---Remove Employee---");
        int id = getValidIntInput("Enter ID of the Employee to be removed.");

        if (manager.removeEmployee(id)) {
            System.out.println("Employee removed successfully.");
        }
    }

    public static void updateEmployee() {

        System.out.println("\n----Update Employee---");
        int id = getValidIntInput("Enter the ID of the Employee to update: ");

        Employee emp = manager.getEmployee(id);

        if (emp == null) {
            System.out.println("Employee does not exist.");
            return;
        }
        System.out.print(
                "Enter new name for employee or leave blank(press Enter) to keep current name: " + emp.getName());
        String name = scanner.nextLine();

        name = name.isEmpty() ? emp.getName() : name;

        System.out.print(
                "Enter new Department for employee or leave blank(press Enter) to keep current department: "
                        + emp.getDept());
        String dept = scanner.nextLine();

        dept = dept.isEmpty() ? emp.getDept() : dept;

        System.out.print("Enter new salary or leave blank(press Enter) to keep current salary: " + emp.getSal());

        String salaryInput = scanner.nextLine();
        double salary = emp.getSal();

        if (!salaryInput.isEmpty()) {
            try {
                salary = Double.parseDouble(salaryInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input entered.Using current salary.");
            }
        }

        try {
            if (manager.updateEmployee(id, name, dept, salary)) {
                System.out.println("Employee updated successfully.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void listEmployees() {

        System.out.println("\n---Employee List---");
        List<Employee> employees = manager.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No Employee Found.");
            return;
        }
        for (Employee emp : employees) {
            System.out.println(emp);
        }

}

}
