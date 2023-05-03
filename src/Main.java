import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer,Car> hashTable = new MyHashTable<>(100);
        Random rnd = new Random();

        for (int i = 0; i < 10000; i++) {
            char brand = (char) rnd.nextInt(65,92); //random character A-Z
            char model = (char) rnd.nextInt(97,123);//random character a-z
            int yearOfProduction = rnd.nextInt(1900,2024);

            Car car = new Car(brand,model,yearOfProduction);

            hashTable.put(car.hashCode(),car);
        }

        System.out.println(hashTable);
    }
}