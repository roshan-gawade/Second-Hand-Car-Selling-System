package secondHandCarsSelling;

public class MonthlyEMI {

    public MonthlyEMI(double emiAmount, int month, int year) {
        this.emiAmount = emiAmount;
        this.month = month;
        this.year = year;
    }

    public double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(double emiAmount) {
        this.emiAmount = emiAmount;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return month + " " + year + " " + emiAmount + " " + isPaid;
    }

    //Class fields
    private double emiAmount;
    private int month;
    private int year;
    private boolean isPaid;
}
