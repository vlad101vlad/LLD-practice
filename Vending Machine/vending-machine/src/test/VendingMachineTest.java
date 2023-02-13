package test;

import domain.Coin;
import domain.Product;
import domain.VendingMachineProducts;
import repository.MockVendingMachineRepository;
import service.VendingMachine;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VendingMachineTest implements ITestable {
    private VendingMachine vendingMachine;

    public VendingMachineTest() {
        this.resetState();
    }

    private void resetState() {
        this.vendingMachine = new VendingMachine(new MockVendingMachineRepository());
    }

    @Override
    public void runTests() {
        shouldReturnTwoDimesAndTwoPennies_22asChange();
        shouldReturnNoCoins_noChange();
    }

    private void shouldReturnTwoDimesAndTwoPennies_22asChange() {
        vendingMachine.addCoin(Coin.DIME); vendingMachine.addCoin(Coin.DIME);
        vendingMachine.addCoin(Coin.PENNY); vendingMachine.addCoin(Coin.PENNY);

        List<Coin> expectedCoins = List.of(Coin.DIME, Coin.DIME, Coin.PENNY, Coin.PENNY);
        assert expectedCoins.equals(vendingMachine.getRemainingChange());

        resetState();
    }

    private void shouldReturnNoCoins_noChange() {
        List<Coin> expectedCoins = new ArrayList<>();
        assert expectedCoins.equals(vendingMachine.getRemainingChange());

        resetState();
    }

    private void shouldReturnCola_ColaInput() {
        var expectedProduct = new Product(VendingMachineProducts.COLA.name(), 200, Date.from(Instant.now()));
        var actualProduct = vendingMachine.getProduct(VendingMachineProducts.COLA);

        assert actualProduct.equals(expectedProduct);
    }
}
