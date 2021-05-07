package secondHandCarsSelling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Profit {
    private static Scanner scanner = new Scanner(System.in);

    static {
        profitPerYearList = new ArrayList<>();
    }

    public static void getProfitPerYearList() {
        if (profitPerYearList.isEmpty()) {
            System.out.println("No Profit record...!");
            return;
        }
        for (ProfitPerYear profitPerYear : profitPerYearList){
            System.out.println(profitPerYear);
        }
    }

    public static void addProfit() {
        System.out.print("\nEnter profit amount, year and car ID: ");
        double profitAmount = scanner.nextDouble();
        int profitYear = scanner.nextInt();
        int carID = scanner.nextInt();

        profitPerYearList.add(new ProfitPerYear(profitAmount, profitYear, carID));
        System.out.println("Process completed...!");
    }

    public static void setProfit() {
        System.out.print("\nEnter profit amount, year and car ID: ");
        double profitAmount = scanner.nextDouble();
        int profitYear = scanner.nextInt();
        int carID = scanner.nextInt();

        if (profitPerYearList.isEmpty()) {
            System.out.println("No Profit record...!");
            return;
        }
        boolean carFound = false;
        for (ProfitPerYear profitPerYear : profitPerYearList){
            if (profitPerYear.carID == carID && profitPerYear.profitYear == profitYear){
                profitPerYear.profitAmount = profitAmount;
                carFound = true;
            }
        }
        if (carFound) {
            System.out.println("Process completed...!");
        } else {
            System.out.println("Car Profit record not found...!");
        }
    }
    public static void removeProfit() {
        System.out.print("Enter Car ID: ");
        int carID = scanner.nextInt();
        System.out.print("\nEnter Profit Year: ");
        int profitYear = scanner.nextInt();
        System.out.println();
        if (profitPerYearList.isEmpty()) {
            System.out.println("No Profit record...!");
            return;
        }
        boolean carFound = false;
        int index = -1;
        for (ProfitPerYear profitPerYear : profitPerYearList){
            if (profitPerYear.carID == carID && profitPerYear.profitYear == profitYear){
                index = profitPerYearList.indexOf(profitPerYear);
                carFound = true;
            }
        }
        if (carFound) {
            profitPerYearList.remove(index);
            System.out.println("Process completed...!");
        } else {
            System.out.println("Car Profit record not found...!");
        }
    }
    private static class ProfitPerYear{

        public ProfitPerYear(double profitAmount, int profitYear, int carID) {
            this.profitAmount = profitAmount;
            this.profitYear = profitYear;
            this.carID = carID;
        }

        public double getProfitAmount() {
            return profitAmount;
        }

        public void setProfitAmount(double profitAmount) {
            this.profitAmount = profitAmount;
        }

        public int getProfitYear() {
            return profitYear;
        }

        public void setYear(int profitYear) {
            this.profitYear = profitYear;
        }

        public int getCarID() {
            return carID;
        }

        public void setCarID(int carID) {
            this.carID = carID;
        }

        @Override
        public String toString() {
            return profitAmount + " " + profitYear + " " + carID;
        }

        //Inner class fields
        private double profitAmount;
        private int profitYear;
        private int carID;
    }

    //Class fields
    private static List<ProfitPerYear> profitPerYearList;
}
