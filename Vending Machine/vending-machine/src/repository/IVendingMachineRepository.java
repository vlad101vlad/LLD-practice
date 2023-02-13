package repository;

import domain.Product;
import domain.VendingMachineProducts;

import java.util.List;

public interface IVendingMachineRepository {
    void addStock(Product product);
    void addStock(List<Product> products);
    Product getProduct(VendingMachineProducts vendingMachineProduct) throws Exception;
}
