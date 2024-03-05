import org.example.Card;
import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WalletTest {

    @Test
    void testWithdrawKelebihan() {
        Wallet wallet = new Wallet("Jee", 100000.0);
        wallet.withdraw(120000.0);
        Assertions.assertEquals(100000.0, wallet.getCash());
    }

    @Test
    void testWithdraw() {
        Wallet wallet = new Wallet("Jee", 10000.0);
        wallet.withdraw(8000.0);
        assertEquals(2000.0, wallet.getCash());
    }

    @Test
    void testDeposit(){
        Wallet wallet = new Wallet("Jee", 100000.0);
        wallet.deposit(100000.0);
        Assertions.assertTrue(wallet.getCash() == 200000.0);
    }

    @Test
    void testDepositMinus() {
        Wallet wallet = new Wallet("Jee", 100000.0);
        wallet.deposit(-10000.0);
        assertNotEquals(10000.0,wallet.getCash());
    }

    @Test
    void testAddCard(){
        Wallet wallet = new Wallet("Jee", new ArrayList<>(), 100000.0);
        wallet.addCard("Mandiri", 123456);
        wallet.addCard("BRI", 123457);
        wallet.addCard("BNI", 123458);
        wallet.addCard("BCA", 123459);
        wallet.addCard("BSI", 123460);

        // Mendapatkan kartu terakhir dari daftar kartu
        Card lastCard = wallet.getCards().get(wallet.getCards().size() - 1);

        // Menampilkan informasi jumlah kartu terakhir
        System.out.println("Jumlah kartu terakhir Anda: " + wallet.getCards().size());
        assertEquals(5, wallet.getCards().size());
    }

    @Test
    void testRemoveCard(){
        List<Card> cards = new ArrayList<>();
        Wallet wallet = new Wallet("Jee", cards, 10000.0);
        cards.add(new Card("Jee", "123456", "Mandiri", LocalDate.now()));
        cards.add(new Card("Jee", "123457", "BNI", LocalDate.now()));
        cards.add(new Card("Jee", "123458", "BNI", LocalDate.now()));
        cards.add(new Card("Jee", "123459", "BCA", LocalDate.now()));
        cards.add(new Card("Jee", "123460", "BSI", LocalDate.now()));
        wallet.removeCard(123456);
        wallet.removeCard(123460);
        System.out.println("Jumlah kartu terakhir Anda: " + wallet.getCards().size());
        assertEquals(3, wallet.getCards().size());
    }
}
