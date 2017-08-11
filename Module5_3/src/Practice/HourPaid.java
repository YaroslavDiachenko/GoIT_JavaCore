package Practice;


public class HourPaid extends Employee {

    private double hourlyRate;

    public double getHourlyRate() {
        return hourlyRate;
    }

    public HourPaid(double hourlyRate, String name, String surname) {
        super(name, surname);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double countSalary() {
        return (Math.round(20.8 * 8.0 * hourlyRate * 10.0))/10.0;
    }
}
