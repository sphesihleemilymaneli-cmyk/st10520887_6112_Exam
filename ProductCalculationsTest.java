package iproductcalculation;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500.0);
        // VAT on 3500 is 15% = 525.0
        assertEquals(525.0, calc.GetVat(), 0.01);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500.0);
        // Price (3500) + VAT (525) + Commission (175) = 4200.0
        assertEquals(4200.0, calc.GetTotal(), 0.01);
    }
}