package secondHandCarsSelling;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Car implements Cloneable{
    private final static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private static final Scanner scanner = new Scanner(System.in);
    public Car() {
        carAddedDate = new GregorianCalendar();
        carAddedDate.setLenient(false);
        carID = carIDGenerator;
        owner = new Owner();
    }

    public Car(String manufacturingCompany, String model, int launchedYear, int age, double price) {
        this.manufacturingCompany = manufacturingCompany;
        this.model = model;
        this.launchedYear = launchedYear;
        this.age = age;
        this.price = price;
        carAddedDate = new GregorianCalendar();
        carAddedDate.setLenient(false);
        carID = carIDGenerator;
        owner = new Owner();
    }

    public Car(String manufacturingCompany, String model, double price, Calendar carAddedDate) {
        this.manufacturingCompany = manufacturingCompany;
        this.model = model;
        this.price = price;
        this.carAddedDate = carAddedDate;
        carAddedDate.setLenient(false);
        carID = carIDGenerator;
        owner = new Owner();

    }

    public Car(String manufacturingCompany, String model, int launchedYear, int age, String fuelType,
               double kmDriven, double price, Calendar carAddedDate) {
        this.manufacturingCompany = manufacturingCompany;
        this.model = model;
        this.launchedYear = launchedYear;
        this.age = age;
        this.fuelType = fuelType;
        this.kmDriven = kmDriven;
        this.price = price;
        this.carAddedDate = carAddedDate;
        carAddedDate.setLenient(false);
        owner = new Owner();

    }

    public String getManufacturingCompany() {
        return manufacturingCompany;
    }

    public void setManufacturingCompany(String manufacturingCompany) {
        this.manufacturingCompany = manufacturingCompany;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getLaunchedYear() {
        return launchedYear;
    }

    public void setLaunchedYear(int launchedYear) {
        this.launchedYear = launchedYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(double kmDriven) {
        this.kmDriven = kmDriven;
    }

    public Calendar getCarAddedDate() {
        return carAddedDate;
    }

    public void setCarAddedDate(Calendar carAddedDate) {
        this.carAddedDate = carAddedDate;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public static int getTotalCars() {
        return totalCars;
    }

    public static void setTotalCars(int totalCars) {
        Car.totalCars = totalCars;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getEMI() {
        if (emi != 0) {
            return emi;
        }
        else {
            System.out.println("Car EMI has not been set yet!!!");
            return -1;
        }
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public void setEMI(int months) {
        if (sold) {
            if (months == 12){
                emi = (long)((price / 12) + (price * 0.0125));
            }
            else if (months == 24){
                emi = (long)((price / 24) + (price * 0.015));
            }
            else {
                System.out.println("Enter 12 or 24 months");
            }
        }
        else {
            System.out.println("Car is not sold yet!!!");
        }

    }



    {
        totalCars++;
        carIDGenerator++;
    }



    public void getOwner() {

        System.out.println(carID + " " + manufacturingCompany + " " + model + " Owner Name: " + owner.ownerName + ", Owner Contact: " + owner.getOwnerContact() + ", Owner Address: " + owner.getOwnerAddress() + ", Purchased Year: " + owner.getPurchasedYear() + ", Purchased Price: " + owner.getPurchasedPrice());
    }

    private class Owner {
        public Owner() {
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String Name) {
            ownerName = Name;
        }

        public String getOwnerContact() {
            return ownerContact;
        }

        public void setOwnerContact(String Contact) {
            ownerContact = Contact;
        }

        public String getOwnerAddress() {
            return ownerAddress;
        }

        public void setOwnerAddress(String Address) {
            ownerAddress = Address;
        }

        public int getPurchasedYear() {
            return purchasedYear;
        }

        public void setPurchasedYear(int Year) {
            purchasedYear = Year;
        }

        public double getPurchasedPrice() {
            return purchasedPrice;
        }

        public void setPurchasedPrice(double Price) {
            purchasedPrice = Price;
        }

        //Inner class fields
        private String ownerName;
        private String ownerContact;
        private String ownerAddress;
        private int purchasedYear;
        private double purchasedPrice;
    }

    public boolean setOwnerDetails(int carID, String ownerName, String ownerContact, String ownerAddress, int purchasedYear, double purchasedPrice) {
        boolean flag = false;

        if (carID == this.getCarID()){
            owner.setOwnerName(ownerName);
            owner.setOwnerContact(ownerContact);
            owner.setOwnerAddress(ownerAddress);
            owner.setPurchasedYear(purchasedYear);
            owner.setPurchasedPrice(purchasedPrice);
            System.out.println("Owner details stored successfully...!");
            flag = true;
        }

        return flag;
    }



    @Override
    public String toString() throws IllegalArgumentException{
        int month = carAddedDate.get(Calendar.MONTH) + 1;
        String addedDate = carAddedDate.get(Calendar.DAY_OF_MONTH) + "/" + month + "/" + carAddedDate.get(Calendar.YEAR);
        String carInfo = carID + " " + manufacturingCompany + " " + model + " launched: " + launchedYear + " Age: " + age + " Price: " + price + " Added : " + addedDate + " Car Purchased status: ";
        if (isSold()) {
            carInfo += "Sold";
        } else {
            carInfo += "Available";
        }

        return carInfo;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Car car = (Car)super.clone();
        return car;
    }

    @Override
    protected void finalize() {
        totalCars--;
    }

    //class fields
    private String manufacturingCompany;
    private String model;
    private int launchedYear;
    private int age;
    private String fuelType;
    private double kmDriven;
    private Calendar carAddedDate;
    private int carID;
    private static int carIDGenerator;
    private double price;
    private boolean sold;
    private long emi;
    private Owner owner;
    private static int totalCars;

}
