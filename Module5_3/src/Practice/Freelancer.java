package Practice;


public class Freelancer extends HourPaid {
    private double dailyHours;

    public double getDailyHours() {
        return dailyHours;
    }

    public Freelancer(double dailyHours, double hourlyRate, String name, String surname) {
        super(hourlyRate, name, surname);
        this.dailyHours = dailyHours;
    }

    @Override
    public double countSalary() {
        return (Math.round(20.8 * dailyHours * getHourlyRate() * 10.0))/10.0;
    }
}
