package test;

import java.util.ArrayList;
import java.util.List;

public class RunAllTests implements ITestable {
    private List<ITestable> testableList = new ArrayList<>();

    public RunAllTests() {
        testableList.add(
                new VendingMachineTest()
        );
    }

    @Override
    public void runTests() {
        testableList.forEach(ITestable::runTests);
    }
}
