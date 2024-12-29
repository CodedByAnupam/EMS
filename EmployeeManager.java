import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManager {
    private Map<Integer, Employee> employees;

    public EmployeeManager() {
        this.employees = new HashMap<>();
    }

    public boolean addEmployee(Employee employee) {
        if (this.employees.containsKey(employee.getID())) {
            System.out.println("Error: Employee with " + employee.getID() + " already exists.");
            return false;
        }

        this.employees.put(employee.getID(), employee);
    
        return true;
    }

    public boolean removeEmployee(int id) {
        if (!this.employees.containsKey(id)) {
            System.out.println("Error: Employee with ID " + id + " does not exist.");
            return false;
        }

        this.employees.remove(id);
        return true;
    }

    public boolean updateEmployee(int id, String name, String dept, double sal) {
        Employee emp = this.employees.get(id);
        if (emp == null) {
            System.out.println("Error: Employee with ID " + id + " not found.");
            return false;
        }

       
            emp.setName(name);
            emp.setDept(dept);
            emp.setSal(sal);

            return true;

        
    }
    

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(this.employees.values());
    }


    public Employee getEmployee(int id) {
        return this.employees.get(id);
    }

}




