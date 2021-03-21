package sorting.ue.carts;

public class Cart implements Comparable<Cart> {

    private String userName;
    private int numberOfArticles;
    private int totalItemAmount;
    private double totalAmount;

    public Cart(String userName, int numberOfArticles, int totalItemAmount, double totalAmount) {
        this.userName = userName;
        this.numberOfArticles = numberOfArticles;
        this.totalItemAmount = totalItemAmount;
        this.totalAmount = totalAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumberOfArticles() {
        return numberOfArticles;
    }

    public void setNumberOfArticles(int numberOfArticles) {
        this.numberOfArticles = numberOfArticles;
    }

    public int getTotalItemAmount() {
        return totalItemAmount;
    }

    public void setTotalItemAmount(int totalItemAmount) {
        this.totalItemAmount = totalItemAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "userName='" + userName + '\'' +
                ", numberOfArticles=" + numberOfArticles +
                ", totalItemAmount=" + totalItemAmount +
                ", totalAmount=" + totalAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (numberOfArticles != cart.numberOfArticles) return false;
        if (totalItemAmount != cart.totalItemAmount) return false;
        if (Double.compare(cart.totalAmount, totalAmount) != 0) return false;
        return userName != null ? userName.equals(cart.userName) : cart.userName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + numberOfArticles;
        result = 31 * result + totalItemAmount;
        temp = Double.doubleToLongBits(totalAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(Cart o) {
        return Double.compare(this.getTotalAmount(), o.getTotalAmount());
    }
}
