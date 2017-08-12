package Practice;


public class Main {
    public static void main(String[] args) {

        String fileName = "/Users/test/IdeaProjects/GoIT_JavaCore/Module5_3/files/CompanyStaff.txt";

        Company company = Company.readFromFile(fileName);
//        company.showAllEmployees();
        company.sortEmployeesBySalaryDescending();
        company.showAllEmployees();
//        company.writeToFile(fileName);

//        System.out.print("\nCompany's gross monthly expenses: ");
//                "\nCompany's gross monthly expenses: $" + Math.round(company.countMonthlyExpenses()));
//        Company.customFormat(company.countMonthlyExpenses());

    }
}