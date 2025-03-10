import org.example.Wallet;
import org.junit.jupiter.api.*;
import java.util.List;

class WalletTest {
    @Test
    void testEmptyWallet() {
        Wallet wallet = new Wallet();
        Assertions.assertNull(wallet.getOwner(),"Pemilik dompet awal seharusnya Null");
        Assertions.assertTrue(wallet.getCards().isEmpty(), "Dompet baru seharusnya tidak memiliki kartu");
    }

    @Test
    void testSetOwner() {
        Wallet wallet = new Wallet();
        wallet.setOwner("Gio");
        Assertions.assertSame("Gio", wallet.getOwner(), "Pemilik dompet seharusnya adalah Gio");
    }

    @Test
    void testAddCard() {
        Wallet wallet = new Wallet();
        wallet.addCard("Visa");
        wallet.addCard("MasterCard");

        List<String> cards = wallet.getCards();
        Assertions.assertEquals(2, cards.size(), "Seharusnya ada 2 kartu dalam dompet");
        Assertions.assertTrue(cards.contains("Visa"), "Dompet seharusnya berisi kartu 'Visa'");
    }

    @Test
    void testAddMoney() {
        Wallet wallet = new Wallet();
        wallet.addMoney(20000,500);
        Assertions.assertEquals(20500, wallet.getTotalMoney(), "Total uang seharusnya merupakan jumlah uang cash dan coin");
    }

    @Test
    void testWithDrawMoney() {
        Wallet wallet = new Wallet();
        wallet.addMoney(40000,1000);
        wallet.addMoney(21000,200);
        Assertions.assertTrue(wallet.withdrawMoney(50000, 500), "Penarikan seharusnya berhasil karena nominal kurang dari atau sama dengan saldo");
        Assertions.assertFalse(wallet.withdrawMoney(70000,100));
    }

    @Test
    void testTotalMoney() {
        Wallet wallet = new Wallet();
        wallet.addMoney(10000,500);
        Assertions.assertEquals(10500, wallet.getTotalMoney(), "Total uang seharusnya merupakan jumlah uang cash dan coin");
    }
}