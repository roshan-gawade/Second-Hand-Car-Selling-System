package secondHandCarsSelling;

import java.util.ArrayList;
import java.util.List;

public abstract class SearchCar {
    public static List<Car> search (List<Car> cars, int minAge, int maxAge){
        List<Car> foundCars = new ArrayList<>();
        for (Car car : cars){
            if (car.getAge() >= minAge && car.getAge() <= maxAge){
                foundCars.add(car);
            }
        }
        if (foundCars.isEmpty()){
            System.out.println("Car not found");
        }

        return null;
    }

    public static Car search (List<Car> cars, int carID){
        for (Car car : cars){
            if (car.getCarID() == carID){
                try {
                    Car car1 = (Car)car.clone();
                    car1.setSold(true);
                    car.setSold(true);
                    return car1;
                } catch (CloneNotSupportedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Car not found");
        return null;
    }

    public static List<Car> search (List<Car> cars, double price) {
        List<Car> foundCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPrice() ==  price) {
                foundCars.add(car);
            }
        }

        return foundCars;
    }
}
