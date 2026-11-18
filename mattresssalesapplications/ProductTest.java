package mattresssalesapplications;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        int[][] testData = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };
        
        Product product = new Product(testData);
        assertEquals(153, product.GetTotalProductSold());
    }

    @Test
    public void GetAveragesSales_WithValidData_ReturnsCorrectValue() {
        int[][] testData = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };
        
        Product product = new Product(testData);
        assertEquals(17.0, product.GetAverageProductSold(), 0.01);
    }
}