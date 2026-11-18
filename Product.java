package mattresssalesapplications;

public class Product implements IProduct {
    
    // 1D array storing the three mattress names
    private final String[] productNames = {
        "Cozy Nights Monarch mattress",
        "Restonic Barbados mattress",
        "Sealy Phuket mattress"
    };
    
    // 2D array storing sales for 3 products across 3 months
    private final int[][] salesData;

    // Constructor to receive sales data
    public Product(int[][] salesData) {
        this.salesData = salesData;
    }

    @Override
    public int GetTotalProductSold() {
        int total = 0;
        // Loop through rows and columns of the 2D array to add all sales
        for (int[] salesData1 : salesData) {
            for (int j = 0; j < salesData1.length; j++) {
                total += salesData1[j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductSold();
        // Count total number of data points to find the average
        for (int i = 0; i < salesData.length; i++) {
        }
        // Simplified: 3 products * 3 months = 9 total entries
        return (double) total / 9;
    }

    @Override
    public String GetMostPopularProduct() {
        int highestSales = -1;
        String bestProduct = "";
        
        // Find which product has the highest total sales
        for (int i = 0; i < salesData.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                productTotal += salesData[i][j];
            }
            
            if (productTotal > highestSales) {
                highestSales = productTotal;
                bestProduct = productNames[i] + " (" + highestSales + ")";
            }
        }
        return bestProduct;
    }
}