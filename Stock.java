public class Stock {
    private String symbol;
    private String name;
    private double price;
    private int availableShares;

    public Stock(String symbol, String name, double price, int availableShares) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.availableShares = availableShares;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableShares() {
        return availableShares;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailableShares(int availableShares) {
        this.availableShares = availableShares;
    }

    public void buyShares(int quantity) {
        availableShares -= quantity;
    }

    public void sellShares(int quantity) {
        availableShares += quantity;
    }
}
