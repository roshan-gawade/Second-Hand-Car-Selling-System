package secondHandCarsSelling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Payment {
    private static final Scanner scanner = new Scanner(System.in);

    static {
        emiList = new ArrayList<>();
        chequeList = new ArrayList<>();
        cardList = new ArrayList<>();
    }

    public static void getEmiList() {
        if (emiList.isEmpty()) {
            System.out.println("No EMI record...!");
            return;
        }
        for (EMI emi : emiList){
            System.out.println(emi);
        }
    }

    public static void getEmiListOfCustomer(int customerID, int carID) {
        if (emiList.isEmpty()) {
            System.out.println("No EMI record...!");
            return;
        }
        for (EMI emi : emiList){
            if (emi.getCustomer().getCustomerID() == customerID && emi.getCar().getCarID() == carID){
                for (MonthlyEMI monthlyEMI : emi.getMonthlyEMIList()){
                    System.out.println(monthlyEMI);
                }
            }
        }
    }

    public static void setEmiPaymentStatus(int customerID, int carID){
        if (emiList.isEmpty()) {
            System.out.println("No EMI record...!");
            return;
        }
        for (EMI emi : emiList){
            if (emi.getCustomer().getCustomerID() == customerID && emi.getCar().getCarID() == carID){
                emi.setPaymentStatus();
            }
        }
    }

    /*public static void getPendingEMIList() {
        generatePendingEMIList();

        for (Cash cash : pendingCashList){
            System.out.println(cash);
        }
    }*/

    public static void getCashList() {
        if (cashList.isEmpty()) {
            System.out.println("No Cash record...!");
            return;
        }
        for (Cash cash : cashList){
            System.out.println(cash);
        }
    }

    public static void getChequeList() {
        if (chequeList.isEmpty()) {
            System.out.println("No Cheque record...!");
            return;
        }
        for (Cheque cheque : chequeList){
            System.out.println(cheque);
        }
    }

    public static void getCardList() {
        if (cardList.isEmpty()) {
            System.out.println("No Card record...!");
            return;
        }
        for (Card card : cardList){
            System.out.println(card);
        }
    }

    public static void getPendingCashList() {
        generatePendingCashList();

        if (pendingCashList.isEmpty()) {
            System.out.println("Process failed...!");
            return;
        }

        for (Cash cash : pendingCashList){
            System.out.println(cash);
        }
    }

    public static void getPendingChequeList() {
        generatePendingChequeList();

        if (pendingChequeList.isEmpty()) {
            System.out.println("Process failed...!");
            return;
        }

        for (Cheque cheque : pendingChequeList){
            System.out.println(cheque);
        }
    }

    public static void getPendingCardList() {
        generatePendingCardList();

        if (pendingCardList.isEmpty()) {
            System.out.println("Process failed...!");
            return;
        }

        for (Card card : pendingCardList){
            System.out.println(card);
        }
    }


    public static void getPaymentStatus() {
        if (cashList.isEmpty()) {
            System.out.println("No Cash record...!");
            return;
        }
        for (Cash cash : cashList){
            System.out.println(cash.getCustomer().getCustomerID() + " " + cash.getCustomer().getCustomerName() + " " + cash.getCar().getCarID() + " " +cash.isPaid());
        }
    }

    public static void setCashPaymentStatus(int customerID, int carID){
        if (cashList.isEmpty()) {
            System.out.println("No Cash record...!");
            return;
        }
        for (Cash cash : cashList){
            if (cash.getCustomer().getCustomerID() == customerID && cash.getCar().getCarID() == carID){
                System.out.println("Enter payment status(true/false)");
                boolean isPaid = scanner.nextBoolean();
                cash.setPaid(isPaid);
            }
        }
    }

    public static void addToCashList(List<Customer> customers, List<Car> cars) {
        Cash transaction = new Cash();
        System.out.print("\nEnter cash amount: ");
        double cashAmount = scanner.nextDouble();

        transaction.setCashAmount(cashAmount);
        boolean foundCustomer = transaction.setCustomer(customers);
        if (foundCustomer) {
            boolean foundCar = transaction.setCar(cars);
            if (foundCar) {
                cashList.add(transaction);
                System.out.println("Process completed...");
            } else {
                System.out.println("Process failed...!");
            }
        } else {
            System.out.println("Process failed...!");
        }


    }

    public static void deleteFromCashList() {
        if (cashList.isEmpty()) {
            System.out.println("No Cash record...!");
            return;
        }

        System.out.println("\nEnter customer ID and car ID: ");
        int customerID = scanner.nextInt();
        int carID = scanner.nextInt();

        for (Cash transaction : cashList){
            if (transaction.getCustomer().getCustomerID() == customerID && transaction.getCar().getCarID() == carID){
                cashList.remove(transaction);
                return;
            }
        }

        System.out.println("Credentials not matched...");
    }

    public static void setChequePaymentStatus(int customerID, int carID){
        if (chequeList.isEmpty()) {
            System.out.println("No Cheque record...!");
            return;
        }
        for (Cheque cheque : chequeList){
            if (cheque.getCustomer().getCustomerID() == customerID && cheque.getCar().getCarID() == carID){
                System.out.println("Enter payment status(true/false)");
                boolean isPaid = scanner.nextBoolean();
                cheque.setPaid(isPaid);
            }
        }
    }

    public static void addToChequeList(List<Customer> customers, List<Car> cars) {
        Cheque transaction = new Cheque();
        System.out.print("\nEnter cash amount: ");
        double cashAmount = scanner.nextDouble();

        transaction.setChequeAmount(cashAmount);
        boolean foundCustomer = transaction.setCustomer(customers);
        if (foundCustomer) {
            boolean foundCar = transaction.setCar(cars);
            if (foundCar) {
                chequeList.add(transaction);
                System.out.println("Process completed...");
            } else {
                System.out.println("Process failed...!");
            }
        } else {
            System.out.println("Process failed...!");
        }
    }

    public static void deleteFromChequeList() {
        if (chequeList.isEmpty()) {
            System.out.println("No Cheque record...!");
            return;
        }
        System.out.println("\nEnter customer ID and car ID: ");
        int customerID = scanner.nextInt();
        int carID = scanner.nextInt();

        for (Cheque transaction : chequeList){
            if (transaction.getCustomer().getCustomerID() == customerID && transaction.getCar().getCarID() == carID){
                chequeList.remove(transaction);
                return;
            }
        }

        System.out.println("Credentials not matched...");

    }

    public static void setCardPaymentStatus(int customerID, int carID){
        if (cardList.isEmpty()) {
            System.out.println("No Card record...!");
            return;
        }
        for (Card card : cardList){
            if (card.getCustomer().getCustomerID() == customerID && card.getCar().getCarID() == carID){
                System.out.println("Enter payment status(true/false)");
                boolean isPaid = scanner.nextBoolean();
                card.setPaid(isPaid);
            }
        }
    }

    public static void addToCardList(List<Customer> customers, List<Car> cars) {
        Card transaction = new Card();
        System.out.print("\nEnter cash amount: ");
        double cashAmount = scanner.nextDouble();

        transaction.setCardAmount(cashAmount);
        boolean foundCustomer = transaction.setCustomer(customers);
        if (foundCustomer) {
            boolean foundCar = transaction.setCar(cars);
            if (foundCar) {
                cardList.add(transaction);
                System.out.println("Process completed...");
            } else {
                System.out.println("Process failed...!");
            }
        } else {
            System.out.println("Process failed...!");
        }
    }

    public static void deleteFromCardList() {
        if (cardList.isEmpty()) {
            System.out.println("No Card record...!");
            return;
        }
        System.out.println("\nEnter customer ID and car ID: ");
        int customerID = scanner.nextInt();
        int carID = scanner.nextInt();

        for (Card transaction : cardList){
            if (transaction.getCustomer().getCustomerID() == customerID && transaction.getCar().getCarID() == carID){
                cardList.remove(transaction);
                return;
            }
        }

        System.out.println("Credentials not matched...");

    }

    public static void addToEMIList(List<Customer> customers, List<Car> cars) {
        EMI transaction = new EMI();
        transaction.addEMI();
        boolean foundCustomer = transaction.setCustomer(customers);
        if (foundCustomer) {
            boolean foundCar = transaction.setCar(cars);
            if (foundCar) {
                emiList.add(transaction);
                System.out.println("Process completed...");
            } else {
                System.out.println("Process failed...!");
            }
        } else {
            System.out.println("Process failed...!");
        }


    }

    public static void deleteFromEMIList() {
        if (emiList.isEmpty()) {
            System.out.println("No EMI record...!");
            return;
        }
        System.out.println("\nEnter customer ID and car ID: ");
        int customerID = scanner.nextInt();
        int carID = scanner.nextInt();

        for (EMI transaction : emiList){
            if (transaction.getCustomer().getCustomerID() == customerID && transaction.getCar().getCarID() == carID){
                emiList.remove(transaction);
                return;
            }
        }

        System.out.println("Credentials not matched...");

    }

    public static void generatePendingCashList() {
        pendingCashList = new ArrayList<>();

        if (cashList.isEmpty()) {
            System.out.println("No Cash record...!");
            return;
        }
        for (Cash transaction : cashList){
            if (!transaction.isPaid){
                pendingCashList.add(transaction);
            }
        }
    }

    public static void generatePendingChequeList() {
        pendingChequeList = new ArrayList<>();

        if (chequeList.isEmpty()) {
            System.out.println("No Cheque record...!");
            return;
        }
        for (Cheque transaction : chequeList){
            if (!transaction.isPaid){
                pendingChequeList.add(transaction);
            }
        }
    }

    public static void generatePendingCardList() {
        pendingCardList = new ArrayList<>();

        if (cardList.isEmpty()) {
            System.out.println("No Card record...!");
            return;
        }
        for (Card transaction : cardList){
            if (!transaction.isPaid){
                pendingCardList.add(transaction);
            }
        }
    }

    //Inner class
    private static class EMI {

        public EMI () {
            monthlyEMIList = new ArrayList<>();
        }

        private List<MonthlyEMI> getMonthlyEMIList() {
            return monthlyEMIList;
        }

        private void addEMI() {
            System.out.println("Enter amount, month and year(in number format)");
            double amount = scanner.nextDouble();
            int month = scanner.nextInt();
            int year = scanner.nextInt();

            MonthlyEMI monthlyEMI = new MonthlyEMI(amount, month, year);
            monthlyEMIList.add(monthlyEMI);
        }

        private void setPaymentStatus(){
            System.out.println("Enter payment status (true/false), month and year(in number format)");
            boolean isPaid = scanner.nextBoolean();
            int month = scanner.nextInt();
            int year = scanner.nextInt();

            for (MonthlyEMI monthlyEMI : monthlyEMIList){
                if (monthlyEMI.getMonth() == month && monthlyEMI.getYear() == year){
                    monthlyEMI.setPaid(isPaid);
                    return;
                }
            }

            System.out.println("Credentials not matched...");
        }
        private int getEmiDuration() {
            return emiDuration;
        }

        private void setEmiDuration(int emiDuration) {
            this.emiDuration = emiDuration;
        }

        private Customer getCustomer() {
            return customer;
        }

        private boolean setCustomer(List<Customer> customers) {
            System.out.print("Enter customer ID: ");
            int customerID = scanner.nextInt();
            customer = SearchCustomer.search(customers, customerID);
            if (customer == null) {
                return false;
            }
            return true;
        }

        private Car getCar() {
            return car;
        }

        private boolean setCar(List<Car> cars) {
            System.out.print("Enter car ID: ");
            int carID = scanner.nextInt();
            car = SearchCar.search(cars, carID);
            if (car == null) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return customer.getCustomerName() + " " + car.getManufacturingCompany() + " " + car.getModel() + " EMI Duration: " + emiDuration;
        }

        //Inner class fields
        private List<MonthlyEMI> monthlyEMIList;
        private int emiDuration;
        private Customer customer;
        private Car car;
    }

    private static class Cash{
        private double getCashAmount() {
            return cashAmount;
        }

        private void setCashAmount(double cashAmount) {
            this.cashAmount = cashAmount;
        }

        private Customer getCustomer() {
            return customer;
        }

        private boolean setCustomer(List<Customer> customers) {
            System.out.print("Enter customer ID: ");
            int customerID = scanner.nextInt();
            customer = SearchCustomer.search(customers, customerID);
            if (customer == null) {
                return false;
            }
            return true;
        }

        private Car getCar() {
            return car;
        }

        private boolean setCar(List<Car> cars) {
            System.out.print("Enter car ID: ");
            int carID = scanner.nextInt();
            car = SearchCar.search(cars, carID);
            if (car == null) {
                return false;
            }
            return true;
        }

        private boolean isPaid() {
            return isPaid;
        }

        private void setPaid(boolean paid) {
            isPaid = paid;
        }

        @Override
        public String toString() {
            return customer.getCustomerName() + " " + car.getManufacturingCompany() + " " + car.getModel() +" " + cashAmount + " " + isPaid;
        }

        //Inner class fields
        private double cashAmount;
        private Customer customer;
        private Car car;
        private boolean isPaid;
    }

    private static class Cheque{
        private double getChequeAmount() {
            return chequeAmount;
        }

        private void setChequeAmount(double chequeAmount) {
            this.chequeAmount = chequeAmount;
        }

        private Customer getCustomer() {
            return customer;
        }

        private boolean setCustomer(List<Customer> customers) {
            System.out.print("Enter customer ID: ");
            int customerID = scanner.nextInt();
            customer = SearchCustomer.search(customers, customerID);
            if (customer == null) {
                return false;
            }
            return true;
        }

        private Car getCar() {
            return car;
        }

        private boolean setCar(List<Car> cars) {
            System.out.print("Enter car ID: ");
            int carID = scanner.nextInt();
            car = SearchCar.search(cars, carID);
            if (car == null) {
                return false;
            }
            return true;
        }

        private boolean isPaid() {
            return isPaid;
        }

        private void setPaid(boolean paid) {
            isPaid = paid;
        }

        @Override
        public String toString() {
            return customer.getCustomerName() + " " + car.getManufacturingCompany() + " " + car.getModel() + " " + chequeAmount + " " + isPaid;
        }

        //Inner class fields
        private double chequeAmount;
        private Customer customer;
        private Car car;
        private boolean isPaid;
    }

    private static class Card{
        private String getCardHolderName() {
            return cardHolderName;
        }

        private void setCardHolderName(String cardHolderName) {
            this.cardHolderName = cardHolderName;
        }

        private double getCardAmount() {
            return cardAmount;
        }

        private void setCardAmount(double cardAmount) {
            this.cardAmount = cardAmount;
        }

        private Customer getCustomer() {
            return customer;
        }

        private boolean setCustomer(List<Customer> customers) {
            System.out.print("Enter customer ID: ");
            int customerID = scanner.nextInt();
            customer = SearchCustomer.search(customers, customerID);
            if (customer == null) {
                return false;
            }
            return true;
        }

        private Car getCar() {
            return car;
        }

        private boolean setCar(List<Car> cars) {
            System.out.print("Enter car ID: ");
            int carID = scanner.nextInt();
            car = SearchCar.search(cars, carID);
            if (car == null) {
                return false;
            }
            return true;
        }

        private boolean isPaid() {
            return isPaid;
        }

        private void setPaid(boolean paid) {
            isPaid = paid;
        }

        @Override
        public String toString() {
            return customer.getCustomerName() + " " + car.getManufacturingCompany() + " " + car.getModel() + " " +
                    cardHolderName + " " + cardAmount + " " + isPaid;
        }

        //Inner class fields
        private String cardHolderName;
        private double cardAmount;
        private Customer customer;
        private Car car;
        private boolean isPaid;
    }

    //Class fields
    private static List<EMI> emiList;
    private static List<EMI> pendingEMIList;
    private static List<Cash> cashList;
    private static List<Cash> pendingCashList;
    private static List<Cheque> chequeList;
    private static List<Cheque> pendingChequeList;
    private static List<Card> cardList;
    private static List<Card> pendingCardList;


}
