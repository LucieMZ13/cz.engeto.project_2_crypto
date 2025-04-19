package cz.engeto.project_2_crypto.demo.model;

public class Crypto {
    private int id;
    private String name;
    private String symbol;
    private double price;
    private double quantity;

    public Crypto() {
    }

    public Crypto(int id, String name, String symbol,
                  double price, double quantity) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cryptoměna " + name + ", ID " + id +
                ", symbol " + symbol + ", cena " +
                price + ", množství " + quantity;
    }
}
