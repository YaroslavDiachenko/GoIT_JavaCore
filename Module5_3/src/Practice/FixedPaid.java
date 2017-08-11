package Practice;


public class FixedPaid extends Employee {

    public FixedPaid(double fixedMonthlyRate, String name, String surname) {
        super(name, surname);
        this.fixedMonthlyRate = fixedMonthlyRate;
    }

    private double fixedMonthlyRate;

    public double getFixedMonthlyRate() {
        return fixedMonthlyRate;
    }

    @Override
    public double countSalary() {
        return fixedMonthlyRate;
    }
}