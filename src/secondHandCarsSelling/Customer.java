package secondHandCarsSelling;

import java.util.*;

public class Customer implements Cloneable{
    Scanner inputInt = new Scanner(System.in);
    Scanner inputStr = new Scanner(System.in);
    public Customer(String customerName) {
        this.customerName = customerName;
        modeOfPayment = new HashMap<>();
        carsPurchased = new ArrayList<>();
        customerAddedDate = new GregorianCalendar();
        customerAddedDate.setLenient(false);
        customerID = customerIDGenerator;
    }

    public Customer(String customerName, String customerAddress, String customerContact) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
        modeOfPayment = new HashMap<>();
        carsPurchased = new ArrayList<>();
        customerAddedDate = new GregorianCalendar();
        customerAddedDate.setLenient(false);
        customerID = customerIDGenerator;
    }

    public Customer(String customerName, String customerAddress, String customerContact, Calendar customerAddedDate) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
        this.customerAddedDate = customerAddedDate;
        customerAddedDate.setLenient(false);
        modeOfPayment = new HashMap<>();
        carsPurchased = new ArrayList<>();
        customerID = customerIDGenerator;
    }

    public Customer(int customerID, String customerName, String customerAddress,
                    String customerContact, Calendar customerAddedDate) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
        this.customerAddedDate = customerAddedDate;
        customerAddedDate.setLenient(false);
        modeOfPayment = new HashMap<>();
        carsPurchased = new ArrayList<>();
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Calendar getCustomerAddedDate() {
        return customerAddedDate;
    }

    public void setCustomerAddedDate(Calendar customerAddedDate) {
        this.customerAddedDate = customerAddedDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }


    public void setCarPurchased(int carID, boolean carPurchased) {
        boolean flag = true;
        if (carsPurchased.isEmpty()){
            System.out.println("No cars present!!!");
            return;
        }
        else{
            for (Car car : carsPurchased) {
                if (car.getCarID() == carID) {
                    car.setSold(carPurchased);
                    flag = false;
                }
            }
        }

        if (flag) {
            System.out.println("Car is not booked by customer...!");
        }

    }

    public void getCarsPurchased() {
        if (carsPurchased.isEmpty()){
            System.out.println("No cars present!!!");
        }
        else{
            for (Car car : carsPurchased){
                System.out.println(car);
            }
        }

    }

    public boolean isCarPurchased(int carID) {
        if (carsPurchased.isEmpty()) {
            System.out.println("No cars booked/purchased yet...!");
            return false;
        }
        for (Car car : carsPurchased) {
            if (car.getCarID() == carID) {
                return true;
            }
        }
        return false;
    }

    public void getModeOfPayment(int carID) {
        if (modeOfPayment == null || modeOfPayment.isEmpty()) {
            System.out.println("No cars booked/purchased yet...!");
            return;
        }
        System.out.println(modeOfPayment.get(carID));
    }

    public void setModeOfPayment(int carID, String mode) {
        if (isCarPurchased(carID)) {
            modeOfPayment.put(carID, mode);
            System.out.println("Mode of payment for customer is set successfully...!");

        } else {
            System.out.println("Car with Car ID " + carID + " is not booked by customer...!");
            return;
        }

    }

    public void setCarsPurchased(List<Car> cars) {
        System.out.println("Enter Car ID");
        int carID = inputInt.nextInt();
        for (Car car : cars){
            if (carID == car.getCarID()) {
                if (car.isSold()) {
                    System.out.println("This car is already purchased, aborted...");
                    return;

                } else {
                    carsPurchased.add(SearchCar.search(cars, carID));
                    System.out.println("Car booked successfully...!");
                    return;
                }
            }

        }

        System.out.println("Car with Car ID " + carID + " is not present...!");

    }

    public static int getTotalCustomers() {
        return totalCustomers;
    }

    {
        totalCustomers++;
        customerIDGenerator++;
    }


    @Override
    public String toString() throws IllegalArgumentException{
        int month = customerAddedDate.get(Calendar.MONTH) + 1;
        String joiningDate = customerAddedDate.get(Calendar.DAY_OF_MONTH) + "/" + month + "/" + customerAddedDate.get(Calendar.YEAR);
        return customerID + " " + customerName + " " + customerContact + " " + customerAddress + " " + " Added : " + joiningDate;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() {
        totalCustomers--;
    }

    //Class fields
    private int customerID;
    private static int customerIDGenerator;
    private String customerName;
    private String customerAddress;
    private String customerContact;
    private Calendar customerAddedDate;
    private List<Car> carsPurchased;
    private HashMap<Integer, String> modeOfPayment;
    private static int totalCustomers;

}
