import org.example.Restoran;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestoranTest {

    // Test method biasa untuk memeriksa harga menu
    @Test
    void testGetHargaBiasa() {
        Assertions.assertEquals(15000, Restoran.getHarga("Nasi Goreng"));
        Assertions.assertEquals(12000, Restoran.getHarga("Mie Ayam"));
        Assertions.assertEquals(-1, Restoran.getHarga("Pizza")); // Menu tidak tersedia
    }

    // Parameterized test untuk memeriksa harga menu
    @Order(1)
    @ParameterizedTest
    @CsvSource({
            "Nasi Goreng, 15000",
            "Mie Ayam, 12000",
            "Pizza, -1"
    })
    void testGetHarga(String menu, int expected) {
        Assertions.assertEquals(expected, Restoran.getHarga(menu));
    }

    // Parameterized test untuk menghitung total harga
    @Order(2)
    @ParameterizedTest
    @CsvSource({
            "Nasi Goreng, 2, 30000",
            "Mie Ayam, 3, 36000",
            "Sate Ayam, 1, 20000"
    })
    void testGetTotalHarga(String menu, int jumlah, int expected) {
        Assertions.assertEquals(expected, Restoran.getTotalHarga(menu, jumlah));
    }

    // Parameterized test untuk memeriksa apakah menu sudah siap
    @Order(3)
    @ParameterizedTest
    @CsvSource({
            "Nasi Goreng, true",
            "Jus Alpukat, false"
    })
    void testIsMenuReady(String menu, boolean expected) {
        Assertions.assertEquals(expected, Restoran.isMenuReady(menu), "Status kesiapan menu" + menu);
    }

    // Parameterized test untuk menu yang tidak ada
    @Order(4)
    @Test
    void testIsMenuReadyNotFound() {
        Assertions.assertFalse(Restoran.isMenuReady("Pizza"), "Menu yang tidak ada harus dianggap belum siap");
    }

    // Parameterized test dengan MethodSource
    @ParameterizedTest
    @MethodSource("TestMenu#provideMenuData")
    void testGetTotalHargaDenganMethodSource(String menu, int jumlah, int expected) {
        Assertions.assertEquals(expected, Restoran.getTotalHarga(menu, jumlah));
    }
}