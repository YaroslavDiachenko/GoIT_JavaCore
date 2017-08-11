package Practice;


public abstract class Employee {
    String name;
    String surname;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public abstract double countSalary();

    public void showEmployee() {
        System.out.println("\nName: " + name + "\nSurname: " + surname);
        if(Company.isFreelancer(this)) System.out.println("Type: Freelancer");
        else if(Company.isFixedPaid(this)) System.out.println("Type: Paid per month");
        else System.out.println("Type: Paid per hour");
        System.out.print("Salary: ");
        Company.customFormat(countSalary());
    }
}
