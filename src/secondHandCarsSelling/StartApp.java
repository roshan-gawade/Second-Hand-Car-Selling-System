package secondHandCarsSelling;

import java.util.*;

public abstract class StartApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Car> cars = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();

    public static void start() {
        try {
            int choice;
            boolean flag = true;
            do {
                printMainMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        customerOperations();
                        break;

                    case 2:
                        carOperations();
                        break;

                    case 3:
                        paymentOperations();
                        break;

                    case 4:
                        profitOperations();
                        break;

                    case 5:
                        flag = false;
                        break;

                    default:
                        System.out.println("Invalid input!!!");
                        break;
                }
            }while (flag);
        } catch (InputMismatchException e) {

            System.out.println("Something wrong with input provided...! \nAborting... \nApp Terminated");
        }

    }









    public static void printMainMenu() {
        System.out.println("\n1. Customer Operations" +
                "\n2. Car Operations" +
                "\n3. Payment Operations" +
                "\n4. Profit Operations" +
                "\n5. Exit");
    }

    public static void printCustomerMenu() {
        System.out.print("\n1. Add Customer" +
                "\n2. Update Customer Details" +
                "\n3. Display Customer Details" +
                "\n4. Set Car Purchased Status" +
                "\n5. Display Car Purchased Status" +
                "\n6. Book a Car" +
                "\n7. Display Car(s) booked/purchased" +
                "\n8. Set Mode of Payment for a Car" +
                "\n9. Display Mode of Payment of a Car" +
                "\n10. Remove Customer" +
                "\n11. Search Customer" +
                "\n12. Display All Customers" +
                "\n13. Exit" +
                "\nEnter your choice: ");
    }

    public static void printCarMenu() {
        System.out.print("\n1. Add Car" +
                "\n2. Update Car Details" +
                "\n3. Display Car Details" +
                "\n4. Set Car Purchased Status" +
                "\n5. Display Car Purchased Status" +
                "\n6. Add Car Owner Details" +
                "\n7. Display Car Owner Details" +
                "\n8. Get EMI Value of Car" +
                "\n9. Set EMI Value of Car" +
                "\n10. Remove Car" +
                "\n11. Search Car" +
                "\n12. Display All Cars" +
                "\n13. Exit" +
                "\nEnter your choice: ");
    }

    public static void printPaymentMenu() {
        System.out.print("\n1. Display EMI List for All Customers" +
                "\n2. Display EMI List of Customer" +
                "\n3. Add EMI to Customer" +
                "\n4. Set EMI Paid Status" +
                "\n5. Display Cash List" +
                "\n6. Add Cash Data of Customer" +
                "\n7. Delete Cash Data of Customer" +
                "\n8. Display Cash Pending Payment Status" +
                "\n9. Update Cash Pending Payment Status" +
                "\n10. Display Cheque List" +
                "\n11. Add Cheque Data of Customer" +
                "\n12. Delete Cheque Data of Customer" +
                "\n13. Display Cheque Pending Payment Status" +
                "\n14. Update Cheque Payment Status" +
                "\n15. Display Card List" +
                "\n16. Add Card Data of Customer" +
                "\n17. Delete Card Data of Customer" +
                "\n18. Display Card Payment Status" +
                "\n19. Update Card Payment Status" +
                "\n20. Exit" +
                "\nEnter your choice: ");
    }

    public static void printProfitMenu() {
        System.out.print("\n1. Display Profit List" +
                "\n2. Add Profit" +
                "\n3. Update Profit a Car" +
                "\n4. Delete Profit of a Car" +
                "\n5. Exit" +
                "\nEnter your choice: ");
    }


    public static void customerOperations() throws InputMismatchException{
        Scanner input = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        String customerName;
        String customerContact;
        String customerAddress;
        int customerID;
        boolean continued = true;
        boolean flag;
        boolean isPaid;
        List<Customer> foundCustomers;

        do {
            printCustomerMenu();
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter customer name, contact and address");
                    customerName = input.nextLine();
                    customerContact = input.nextLine();
                    customerAddress = input.nextLine();
                    Customer newCustomer = new Customer(customerName, customerContact, customerAddress);

                    customers.add(newCustomer);
                    System.out.println("Customer added successfully!!!");
                    break;

                case 2:
                    System.out.println("Enter customer ID, name, contact and address");
                    customerID = scanner1.nextInt();
                    customerName = input.nextLine();
                    customerContact = input.nextLine();
                    customerAddress = input.nextLine();
                    flag = false;

                    for (Customer customer : customers){
                        if (customerID == customer.getCustomerID()){
                            customer.setCustomerName(customerName);
                            customer.setCustomerContact(customerContact);
                            customer.setCustomerAddress(customerAddress);
                            System.out.println("Customer details updated successfully...!");
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Customer not found...!");
                    }
                    break;

                case 3:
                    System.out.println("Enter customer ID");
                    customerID = scanner.nextInt();
                    flag = false;
                    for (Customer customer : customers){
                        if (customerID == customer.getCustomerID()){
                            System.out.println(customer);
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Customer not found!!!");
                    }

                    break;


                case 4:
                    System.out.println("Enter customer ID and car purchased status as true/false");
                    customerID = scanner1.nextInt();
                    isPaid = input.nextBoolean();
                    System.out.println("Enter car ID");
                    int carID = scanner1.nextInt();
                    flag = false;

                    for (Customer customer : customers){
                        if (customerID == customer.getCustomerID()){
                            customer.setCarPurchased(carID, isPaid);
                            System.out.println("Car purchased status set successfully...!");
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Customer not found!!!");
                    }

                    break;

                case 5:
                    System.out.println("Enter customer ID");
                    customerID = scanner1.nextInt();
                    System.out.println("Enter car ID");
                    carID = scanner1.nextInt();
                    flag = false;
                    for (Customer customer : customers){
                        if (customerID == customer.getCustomerID()){
                            System.out.println(customer.isCarPurchased(carID));
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Customer not found!!!");
                    }

                    break;

                case 6:
                    if (cars.isEmpty()){
                        System.out.println("No cars present!!!");
                    }
                    else{
                        System.out.println("Enter customer ID");
                        customerID = scanner1.nextInt();
                        flag = false;
                        for (Customer customer : customers){
                            if (customerID == customer.getCustomerID()){
                                customer.setCarsPurchased(cars);
                                flag = true;
                            }
                        }
                        if (!flag){
                            System.out.println("Customer not found!!!");
                        }
                    }

                    break;

                case 7:
                    System.out.println("Enter customer ID");
                    customerID = scanner1.nextInt();
                    flag = false;
                    for (Customer customer : customers){
                        if (customerID == customer.getCustomerID()){
                            customer.getCarsPurchased();
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Customer not found!!!");
                    }

                    break;

                case 8:
                    System.out.println("Enter customer ID");
                    customerID = scanner1.nextInt();
                    System.out.print("Enter car ID and mode of payment (Cash, Card, EMI, Card)\n");
                    carID = scanner1.nextInt();
                    String mode = input.nextLine();
                    flag = false;
                    for (Customer customer : customers){
                        if (customerID == customer.getCustomerID()){
                            customer.setModeOfPayment(carID, mode);
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Customer not found!!!");
                    }

                    break;

                case 9:
                    System.out.println("Enter customer ID");
                    customerID = scanner1.nextInt();
                    System.out.println("Enter car ID");
                    carID = scanner1.nextInt();
                    flag = false;
                    for (Customer customer : customers){
                        if (customerID == customer.getCustomerID()){
                            customer.getModeOfPayment(carID);
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Customer not found!!!");
                    }

                    break;

                case 10:
                    System.out.println("Enter customer ID");
                    customerID = scanner1.nextInt();
                    flag = false;

                    int index = -1;
                    for (Customer customer : customers){
                        if (customerID == customer.getCustomerID()){
                            index = customers.indexOf(customer);
                            flag = true;
                        }
                    }

                    if (flag) {
                        customers.remove(index);
                        System.out.println("Customer removed successfully...!");
                    } else {
                        System.out.println("Customer not found!!!");
                    }


                    break;

                case 11:
                    System.out.println("Enter customer name");
                    customerName = input.nextLine();
                    flag = false;

                    foundCustomers = SearchCustomer.search(customers, customerName);

                    for (Customer customer : foundCustomers){
                        System.out.println(customer);
                        flag = true;
                    }
                    if (!flag){
                        System.out.println("Customer not found!!!");
                    }

                    break;

                case 12:
                    for (Customer customer : customers){
                        System.out.println(customer);
                    }

                    if (!customers.isEmpty()){
                        System.out.println("Total Customers: " + customers.size());
                    }
                    else {
                        System.out.println("No customers found!!!");
                    }
                    break;

                case 13:
                    continued = false;
                    break;

                default:
                    System.out.println("Invalid input!!!");
                    break;
            }
        }while (continued);

    }

    public static void carOperations() {
        boolean continued = true;
        String carManufacturingCompany;
        String carModel;
        int carLaunchedYear;
        int carAge;
        double carPrice;
        int carID;
        boolean isSold;
        String ownerName;
        String ownerContact;
        String ownerAddress;
        int purchasedYear;
        double purchasedPrice;
        int emiDuration;
        List<Car> foundCars;
        boolean flag = false;



        do {
            printCarMenu();
            Scanner input1 = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);

            int choice = input1.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter car manufacturing company, car model, launched year, age and price");
                    carManufacturingCompany = input2.nextLine();
                    carModel = input2.nextLine();
                    carLaunchedYear = scanner.nextInt();
                    carAge = scanner.nextInt();
                    carPrice = input1.nextDouble();
                    Car newCar = new Car(carManufacturingCompany, carModel, carLaunchedYear, carAge, carPrice);

                    cars.add(newCar);
                    System.out.println("Car added successfully!!!");
                    break;

                case 2:
                    System.out.println("Enter car ID, car manufacturing company, car model, launched year, age and price");
                    carID = scanner.nextInt();
                    carManufacturingCompany = input2.nextLine();
                    carModel = input2.nextLine();
                    carLaunchedYear = scanner.nextInt();
                    carAge = scanner.nextInt();
                    carPrice = input1.nextDouble();
                    flag = false;

                    for (Car car : cars){
                        if (carID == car.getCarID()){
                            car.setManufacturingCompany(carManufacturingCompany);
                            car.setModel(carModel);
                            car.setLaunchedYear(carLaunchedYear);
                            car.setAge(carAge);
                            car.setPrice(carPrice);
                            System.out.println("Car details updated successfully...!");
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Car not found...!");
                    }

                    break;

                case 3:
                    System.out.println("Enter car ID");
                    carID = scanner.nextInt();
                    flag = false;
                    for (Car car : cars){
                        if (carID == car.getCarID()){
                            System.out.println(car);
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Car not found!!!");
                    }

                    break;

                case 4:

                    System.out.println("Enter car ID and car purchased status as true or false");
                    carID = scanner.nextInt();
                    isSold = scanner.nextBoolean();
                    flag = false;

                    for (Car car : cars){
                        if (carID == car.getCarID()){
                            car.setSold(isSold);
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Car not found!!!");
                    }

                    break;

                case 5:
                    System.out.println("Enter car ID");
                    carID = scanner.nextInt();
                    flag = false;
                    for (Car car : cars){
                        if (carID == car.getCarID()){
                            System.out.println(car.isSold());
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Car not found!!!");
                    }

                    break;

                case 6:
                    System.out.println("Enter car ID, owner name, contact, address, car purchased year and car purchased price");
                    carID = scanner.nextInt();
                    ownerName = input2.nextLine();
                    ownerContact = input2.nextLine();
                    ownerAddress = input2.nextLine();
                    purchasedYear = scanner.nextInt();
                    purchasedPrice = input1.nextDouble();

                    for (Car car : cars){
                        flag = car.setOwnerDetails(carID, ownerName, ownerContact, ownerAddress, purchasedYear, purchasedPrice);
                    }
                    if (!flag){
                        System.out.println("Car not found!!!");
                    }

                    break;

                case 7:
                    System.out.println("Enter car ID");
                    carID = scanner.nextInt();
                    flag = false;
                    for (Car car : cars){
                        if (carID == car.getCarID()){
                            car.getOwner();
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Car not found!!!");
                    }

                    break;

                case 8:
                    System.out.println("Enter car ID");
                    carID = scanner.nextInt();
                    flag = false;
                    for (Car car : cars){
                        if (carID == car.getCarID()){
                            System.out.println(car.getCarID() + " " + car.getManufacturingCompany() + " " + car.getModel() + " " + car.getEMI());
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Car not found!!!");
                    }

                    break;

                case 9:
                    System.out.println("Enter car ID and EMI duration in months as 12 or 24");
                    carID = scanner.nextInt();
                    emiDuration = scanner.nextInt();
                    flag = false;
                    for (Car car : cars){
                        if (carID == car.getCarID()){
                            car.setEMI(emiDuration);
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Car not found!!!");
                    }

                    break;

                case 10:
                    System.out.println("Enter Car ID");
                    carID = scanner.nextInt();
                    flag = false;

                    int index = -1;
                    for (Car car : cars){
                        if (carID == car.getCarID()){
                            index = cars.indexOf(car);
                            flag = true;
                        }
                    }

                    if (flag) {
                        cars.remove(index);
                        System.out.println("Car removed successfully...!");
                    } else {
                        System.out.println("Car not found!!!");
                    }


                    break;

                case 11:
                    System.out.println("Enter car price");
                    carPrice = scanner.nextDouble();
                    flag = false;

                    foundCars = SearchCar.search(cars, carPrice);

                    if (foundCars != null) {
                        for (Car car : foundCars){
                            System.out.println(car);
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Car not found!!!");
                    }

                    break;

                case 12:
                    for (Car car : cars){
                        System.out.println(car);
                    }

                    if (!cars.isEmpty()){
                        System.out.println("Total Cars: " + cars.size());
                    }
                    else {
                        System.out.println("No cars found!!!");
                    }

                    break;

                case 13:
                    continued = false;
                    break;

                default:
                    System.out.println("Invalid input!!!");
                    break;
            }
        }while (continued);
    }

    public static void paymentOperations() {
        int customerID;
        int carID;
        boolean continued = true;
        do {
            printPaymentMenu();
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    Payment.getEmiList();
                    break;

                case 2:
                    System.out.println("\nEnter customer ID and car ID: ");
                    customerID = scanner.nextInt();
                    carID = scanner.nextInt();

                    Payment.getEmiListOfCustomer(customerID, carID);

                    break;

                case 3:
                    Payment.addToEMIList(customers, cars);
                    break;

                case 4:
                    System.out.println("\nEnter customer ID and car ID: ");
                    customerID = scanner.nextInt();
                    carID = scanner.nextInt();

                    Payment.setEmiPaymentStatus(customerID, carID);
                    break;

                case 5:
                    Payment.getCashList();
                    break;

                case 6:
                    Payment.addToCashList(customers, cars);
                    break;

                case 7:
                    Payment.deleteFromCashList();
                    break;

                case 8:
                    Payment.getPendingCashList();
                    break;

                case 9:
                    System.out.println("\nEnter customer ID and car ID: ");
                    customerID = scanner.nextInt();
                    carID = scanner.nextInt();

                    Payment.setCashPaymentStatus(customerID, carID);
                    break;

                case 10:
                    Payment.getChequeList();
                    break;

                case 11:
                    Payment.addToChequeList(customers, cars);
                    break;

                case 12:
                    Payment.deleteFromChequeList();
                    break;

                case 13:
                    Payment.getPendingChequeList();
                    break;

                case 14:
                    System.out.println("\nEnter customer ID and car ID: ");
                    customerID = scanner.nextInt();
                    carID = scanner.nextInt();

                    Payment.setChequePaymentStatus(customerID, carID);
                    break;

                case 15:
                    Payment.getCardList();
                    break;

                case 16:
                    Payment.addToCardList(customers, cars);
                    break;

                case 17:
                    Payment.deleteFromCardList();
                    break;

                case 18:
                    Payment.getPendingCardList();
                    break;

                case 19:
                    System.out.println("\nEnter customer ID and car ID: ");
                    customerID = scanner.nextInt();
                    carID = scanner.nextInt();

                    Payment.setCardPaymentStatus(customerID, carID);
                    break;

                case 20:
                    continued = false;
                    break;

                default:
                    System.out.println("Invalid input!!!");
                    break;
            }
        }while (continued);
    }




    public static void profitOperations() {
        boolean continued = true;

        do {
            printProfitMenu();
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    Profit.getProfitPerYearList();
                    break;

                case 2:
                    Profit.addProfit();
                    break;

                case 3:
                    Profit.setProfit();
                    break;

                case 4:
                    Profit.removeProfit();
                    break;

                case 5:
                    continued = false;
                    break;

                default:
                    System.out.println("Invalid input!!!");
                    break;
            }
        }while (continued);
    }


}
