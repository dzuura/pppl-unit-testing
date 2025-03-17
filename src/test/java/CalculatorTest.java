import org.example.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
//    @BeforeAll
//    static void setup() {
//        System.out.println("beforeAll");
//    }
//
//    @BeforeEach
//    void setupMethod() {
//        System.out.println("beforeEach");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("afterAll");
//    }
//
//    @AfterEach
//    void afterEach() {
//        System.out.println("afterEach");
//    }

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

    // pertemuan 5
    @Test
    void testCalculatorAdd() {
        Assertions.assertEquals(11, Calculator.add(1,10));
        Assertions.assertEquals(30, Calculator.add(10,20));
        Assertions.assertEquals(5, Calculator.add(2,3));
    }

    @Order(1)
    @ParameterizedTest
    @CsvSource ({
            "1, 10, 11",
            "10, 20, 30",
            "2, 3, 5"
    })
    void testAddition(int a, int b, int expected) {
        Assertions.assertEquals(expected, Calculator.add(a,b));
    }

    @Order(2)
    @ParameterizedTest
    @CsvSource({
            "1, 10 ,10",
            "10, 20, 200",
            "2, 3, 6",
    })
    void testMultiply(int a, int b, int expected) {
        Assertions.assertEquals(expected, Calculator.multiply(a,b));
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10})
    void testIsEven(int number) {
        Assertions.assertTrue(Calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "def", "fgh"})
    void testString(String word) {

    }

    // method untuk menyediakan array
    static Stream<List<String>> provideArray(){
        return Stream.of(
                Arrays.asList("abc", "def", "ghi"),
                Arrays.asList("jlk", "mno", "pqr")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArray")
    void testYangPakaiArray(List<String> array){
        Assertions.assertNotNull(array);
    }

    static Stream<Arguments> provideAddData() {
        return Stream.of(
                Arguments.of(1,10,11),
                Arguments.of(2,3,5),
                Arguments.of(10,20,30)
        );
    }

    @ParameterizedTest
    @MethodSource("provideAddData")
    void testAddPakaiMethod(int a, int b, int expected) {
        Assertions.assertEquals(expected, Calculator.add(a,b));
    }

    // method provideAddData ada di class TestData
    // method harus static agar tidak di-create
    @ParameterizedTest
    @MethodSource("TestData#provideAddData")
    void testAddPakaiMethod2(int a, int b, int expected) {
        Assertions.assertEquals(expected, Calculator.add(a,b));
    }
}
