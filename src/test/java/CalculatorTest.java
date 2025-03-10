import org.example.Calculator;
import org.junit.jupiter.api.*;

public class CalculatorTest {
    @Test
    void testTambah() {
        Calculator calc = new Calculator(10, 5);
        Assertions.assertEquals(15, calc.tambah(), "Penjumlahan 10 + 5 seharusnya 15");
        Assertions.assertAll(
                () -> Assertions.assertEquals(15, calc.tambah())
        );
    }

    @Test
    void testKurang() {
        Calculator calc = new Calculator(10, 5);
        Assertions.assertEquals(5, calc.kurang(), "Pengurangan 10 - 5 seharusnya 5");
    }

    @Test
    void testKali() {
        Calculator calc = new Calculator(10, 5);
        Assertions.assertEquals(50, calc.kali(), "Perkalian 10 * 5 seharusnya 50");
    }

    @Test
    void testBagi() {
        Calculator calc = new Calculator(10, 5);
        Assertions.assertEquals(2, calc.bagi(), "Pembagian 10 / 5 seharusnya 2");
    }

    @Test
    void testBagiDenganNol() {
        Calculator calc = new Calculator(10, 0);
        Assertions.assertThrows(ArithmeticException.class, calc::bagi, "Pembagian dengan nol harus melempar ArithmeticException");
    }
}
