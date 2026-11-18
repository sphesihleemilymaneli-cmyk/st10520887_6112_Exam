package iproductcalculation;

public class ProductCalculations implements IProductCalculation {
    
    private final double price;

    // Entered price
    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double GetVat() {
        // VAT = 15% 
        return price * 0.15;
    }

    @Override
    public double GetCommission() {
        // Commission = 5% of the product price
        return price * 0.05;
    }

    @Override
    public double GetTotal() {
        // Calculation of Total Sale Amount
        return price + GetVat() + GetCommission();
    }
}