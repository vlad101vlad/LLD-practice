import domain.VendingMachineProducts;
import test.RunAllTests;

public class Main {

    public static void runTests() {
        var tests = new RunAllTests();
        tests.runTests();
    }
    public static void main(String[] args) {
        runTests();



        System.out.println(VendingMachineProducts.valueOf("COLA"));
    }
}
