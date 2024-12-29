public class Employee {

    private int id;
    private String name;
    private String dept;
    private double sal;

    public Employee(int id, String name, String dept, double sal) {
        if (!validId(id)) {
            throw new IllegalArgumentException("Invalid id");
        }

        if (!validName(name)) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }

        if (!validDept(dept)) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }

        if (!validSal(sal)) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }

        this.id = id;
        this.name = name;
        this.dept = dept;
        this.sal = sal;
    }

    public boolean validSal(double sal) {

        return sal > 0;
    }

    public boolean validDept(String dept) {

        return dept != null && !dept.trim().isEmpty();
    }

    public boolean validName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public boolean validId(int id) {
        return id > 0;
    }

    // public void setID(int id) {
    //     if (!validId(id)) {
    //         throw new IllegalArgumentException("Invalid id");
    //     }
    //     this.id = id;
    // }

    public void setName(String name) {
        if (!validName(name)) {
            throw new IllegalArgumentException("name cannot be empty or null.");
        }
        this.name = name;
    }

    public void setDept(String dept) {
        if (!validDept(dept)) {
            throw new IllegalArgumentException("Invalid Department: Dept cannot be null or empty.");
        }
        this.dept = dept;
    }

    public void setSal(double sal) {
        if (!validSal(sal)) {
            throw new IllegalArgumentException("Invalid Salary: Salary must be positive");
        }

        this.sal = sal;
    }


    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDept() {
        return this.dept;
    }

    public double getSal() {
        return this.sal;
    }
    

    public String toString() {
        return String.format("ID: %d | Name: %s | Department: %s | Salary: %.2f", this.id, this.name, this.dept,
                this.sal);
    }
}