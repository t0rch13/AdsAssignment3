public class Car {
    // testing class for hashtable, cars
    private char brand;
    private char model;
    private int yearOfProduction;

    public Car(char brand, char model, int yearOfProduction){
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }
    @Override
    public int hashCode(){
        int hash = 1;
        hash = 31*hash + brand; //31x + y rule
        hash = 31*hash + model;
        hash = 31*hash + yearOfProduction;
        return hash;
    }

}
