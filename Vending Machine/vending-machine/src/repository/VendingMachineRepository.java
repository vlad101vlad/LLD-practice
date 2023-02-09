package repository;

import domain.Product;
import domain.VendingMachineProducts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineRepository {
    private Map<String, List<Product>> stock = new HashMap<>();
    private boolean isSorted = true;

    public VendingMachineRepository() {
        Arrays.stream(VendingMachineProducts.values()).forEach(vendingMachineProduct
                -> stock.put(vendingMachineProduct.name(), new ArrayList<>()));
    }

    public void addStock(Product product) {
        stock.get(product.getName()).add(product);
        isSorted = false;
    }

    public void addStock(List<Product> products) {
        products.forEach(this::addStock);
    }

    private void sortProductsByExpirationDate(List<Product> products) {
        products.sort(Comparator.comparing(Product::getExpirationDate));
        isSorted = true;
    }

    public Product getProduct(VendingMachineProducts vendingMachineProduct) throws Exception {
        var productStock = stock.get(vendingMachineProduct.name());

        if(productStock.isEmpty())
            throw new Exception("Items out of stock");
        if(!isSorted)
            sortProductsByExpirationDate(productStock);

        return stock.get(productStock).get(0);
    }
}
