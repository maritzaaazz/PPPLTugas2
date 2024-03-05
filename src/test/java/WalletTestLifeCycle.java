import org.example.Card;
import org.example.Wallet;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WalletTestLifeCycle {
    static List<Wallet> wallet;
    static List<Card> Cards = new ArrayList<>();

    @BeforeAll
    static void initClass(){
        System.out.println("Before All dijalankan");
        wallet = new ArrayList<>();
    }

    @BeforeEach
    void initMethod(){
        System.out.println("Before Each dijalankan");
        LocalDate expirationDate = LocalDate.parse("2022-03-05");
        Cards.add(new Card("Jee", "123456", "Mandiri", expirationDate));

        Wallet wallet1 = new Wallet("Jee", Cards, 10000.0);
        wallet.add(wallet1);
    }

    @Test
    void testWithdrawKelebihan() {
        wallet.get(0).withdraw(120000.0);
        assertEquals(10000.0, wallet.get(0).getCash());
        System.out.println("testWithdrawKelebihan dijalankan");
    }


    @Test
    void testWithdraw() {
        wallet.get(0).withdraw(8000.0);
        assertEquals(2000.0, wallet.get(0).getCash());
        System.out.println("testWithdraw dijalankan");
    }

    @Test
    void testDeposit(){
        wallet.get(0).deposit(10000.0);
        Assertions.assertTrue(wallet.get(0).getCash() == 20000.0);
        System.out.println("testDeposit dijalankan");
    }

    @Test
    void testDepositMinus() {
        wallet.get(0).deposit(-80000.0);
        assertNotEquals(20000.0, wallet.get(0).getCash());
        System.out.println("testDepositMinus dijalankan");
    }

    @Test
    void testAddCard(){
        wallet.get(0).addCard("BRI", 123457);
        wallet.get(0).addCard("BNI", 1234568);
        assertEquals(3, wallet.get(0).getCards().size());
        System.out.println("testAddCard dijalankan");
    }

    @Test
    void testRemoveCard(){
        Wallet wallet = new Wallet("Jee", Cards, 10000.0);
        LocalDate expirationDate = LocalDate.parse("2022-03-05");
        Cards.add(new Card("Jee", "123459", "BSI", expirationDate));
        Cards.add(new Card("Jee", "123457", "BNI", expirationDate));
        Cards.add(new Card("Jee", "123458", "BCA", expirationDate));

        wallet.removeCard(123460);
        assertEquals(4, wallet.getCards().size());
        System.out.println("testRemoveCard dijalankan");
    }

    @AfterEach
    void closeMethod(){
        System.out.println("After Each dijalankan");
        wallet.clear();
        Cards.clear();
    }

    @AfterAll
    static void closeClass(){
        System.out.println("After All dijalankan");
        Cards = null;
        wallet = null;
    }
}
