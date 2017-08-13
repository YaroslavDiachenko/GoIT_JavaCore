package Practice;


public class Main {
    public static void main(String[] args) {

        String fileName = "/Users/test/IdeaProjects/GoIT_JavaCore/Module5_3/files/CompanyStaff.txt";

        Company company = Company.readFromFile(fileName);
        company.sortEmployeesBySalaryAscending();
        company.showAllEmployees();
        company.countAndShowMonthlyExpenses();
    }
}