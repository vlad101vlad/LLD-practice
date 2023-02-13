package service;

import domain.Coin;
import domain.Product;
import domain.VendingMachineProducts;
import repository.IVendingMachineRepository;
import repository.VendingMachineRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VendingMachine {
    private IVendingMachineRepository vendingMachineRepository;
    private Integer amount;

    public VendingMachine(IVendingMachineRepository vendingMachineRepository) {
        this.amount = 0;
        this.vendingMachineRepository = vendingMachineRepository;
    }

    public void addCoin(Coin coin) {
        amount += coin.getValue();
    }

    public List<Coin> getRemainingChange() {
        return new ArrayList<>();
    }

    public Product getProduct(VendingMachineProducts productName) {
        return new Product("", 2, Date.from(Instant.now()));
    }

    void resetMachine() {

    }

    public Integer getAmount() {
        return amount;
    }
}
