import com.github.javafaker.Faker;

public class Utils {
    public static String getFirstName(){
        return new Faker().name().firstName();
    }
    public static String getLastName() {
        return new Faker().name().lastName();
    }
    public static String getZipCode(){
        return new Faker().address().zipCode();
    }
}
