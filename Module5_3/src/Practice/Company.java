package Practice;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Company {

    Employee[] staff;

    Company(Employee[] staff) {
        this.staff = staff;
    }

    double countMonthlyExpenses() {
        double monthlyExpenses = 0;
        for (Employee i : staff) {
            monthlyExpenses += i.countSalary();
        }
        return monthlyExpenses;
    }

    void showAllEmployees() {
        for (Employee i : staff) {
            i.showEmployee();
        }
    }

    void writeToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Employee i : staff) {
                if (isFreelancer(i)) {
                    writer.write("Freelancer\n");
                    writer.write("" + ((Freelancer) i).getDailyHours() + "\n");
                    writer.write("" + ((Freelancer) i).getHourlyRate() + "\n");
                } else if (isFixedPaid(i)) {
                    writer.write("FixedPaid\n");
                    writer.write("" + ((FixedPaid) i).getFixedMonthlyRate() + "\n");
                } else {
                    writer.write("HourPaid\n");
                    writer.write("" + ((HourPaid) i).getHourlyRate() + "\n");
                }
                writer.write(i.name + "\n");
                writer.write("" + i.surname + "\n\n");

            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Company readFromFile(String fileName) {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
            String className = br.readLine();
            while (className != null) {
                switch (className) {
                    case "HourPaid":
                        staff.add(new HourPaid(
                                Double.parseDouble(br.readLine()), // hourlyRate
                                br.readLine(), // name
                                br.readLine() // surname
                        ));
                        break;
                    case "FixedPaid":
                        staff.add(new FixedPaid(
                                Double.parseDouble(br.readLine()), // fixedMonthlyRate
                                br.readLine(), // name
                                br.readLine() // surname
                        ));
                        break;
                    case "Freelancer":
                        staff.add(new Freelancer(
                                Double.parseDouble(br.readLine()), // dailyHours
                                Double.parseDouble(br.readLine()), // hourlyRate
                                br.readLine(), // name
                                br.readLine() // surname
                        ));
                        break;
                }
                br.readLine();
                className = br.readLine();
            }
            return new Company(staff.toArray(new Employee[staff.size()]));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static boolean isFreelancer(Employee employee) {
        return employee instanceof Freelancer;
    }

    static boolean isFixedPaid(Employee employee) {
        return employee instanceof FixedPaid;
    }

    static void customFormat(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("$###,###.###");
        String output = decimalFormat.format(value);
        System.out.println(output);
    }

    public void sortEmployeesBySalaryAscending() {
        int n = staff.length;
        Employee temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (staff[j - 1].countSalary() > staff[j].countSalary()) {
                    temp = staff[j - 1];
                    staff[j - 1] = staff[j];
                    staff[j] = temp;
                }
            }
        }
    }

    public void sortEmployeesBySalaryDescending() {
        int n = staff.length;
        Employee temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (staff[j - 1].countSalary() < staff[j].countSalary()) {
                    temp = staff[j - 1];
                    staff[j - 1] = staff[j];
                    staff[j] = temp;
                }
            }
        }
    }

}
