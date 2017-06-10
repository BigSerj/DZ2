package Task3_InternalClasses;

public class City {

    CityInnerClass avenue = new CityInnerClass();
    CityInnerClass prospect = new CityInnerClass();
    CityInnerClass street = new CityInnerClass();

    CityInnerClass avenue2 = new CityInnerClass();
    CityInnerClass prospect2 = new CityInnerClass();
    CityInnerClass street2 = new CityInnerClass();

    class CityInnerClass {
        String name;
    }
}
