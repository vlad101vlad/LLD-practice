package repository;

import domain.Product;
import domain.VendingMachineProducts;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class MockVendingMachineRepository implements IVendingMachineRepository {

    public MockVendingMachineRepository() {
    }

    @Override
    public void addStock(Product product) {

    }

    @Override
    public void addStock(List<Product> products) {

    }

    @Override
    public Product getProduct(VendingMachineProducts vendingMachineProduct) throws Exception {
        return new Product(vendingMachineProduct.name(), 999, Date.from(Instant.now()));
    }
}
