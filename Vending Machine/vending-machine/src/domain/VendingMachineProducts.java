package domain;

public enum VendingMachineProducts {
    COLA("Cola", 25),
    PEPSI("Pepsi", 35),
    SODA("Soda", 45);

    private final String name;
    private final int price;

    VendingMachineProducts(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
