import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyTests {

    @Test
    public void whenNotEnoughChangeShouldLowerPrice() {

        List<Integer> moneyInMachine = new ArrayList<>();
        moneyInMachine.add(1);
        moneyInMachine.add(50);

        List<Integer> moneyInput = new ArrayList<>();
        moneyInput.add(200);
        moneyInput.add(50);
        moneyInput.add(20);

        List<Integer> actual = Main.calculateChange(moneyInMachine, moneyInput, 254);

        List<Integer> expected= new ArrayList<>();
        expected.add(20);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateChangeCorrectly() {

        List<Integer> moneyInMachine = new ArrayList<>();
        moneyInMachine.add(1);
        moneyInMachine.add(1);
        moneyInMachine.add(1);
        moneyInMachine.add(2);
        moneyInMachine.add(2);
        moneyInMachine.add(2);
        moneyInMachine.add(2);
        moneyInMachine.add(5);
        moneyInMachine.add(50);
        moneyInMachine.add(100);
        moneyInMachine.add(500);

        List<Integer> moneyInput = new ArrayList<>();
        moneyInput.add(200);
        moneyInput.add(50);
        moneyInput.add(20);

        List<Integer> actual = Main.calculateChange(moneyInMachine, moneyInput, 254);

        List<Integer> expected= new ArrayList<>();
        expected.add(5);
        expected.add(2);
        expected.add(2);
        expected.add(2);
        expected.add(2);
        expected.add(1);
        expected.add(1);
        expected.add(1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldUseInputMoneyToReturnChange() {

        List<Integer> moneyInMachine = new ArrayList<>();
        moneyInMachine.add(1);
        moneyInMachine.add(1);
        moneyInMachine.add(2);
        moneyInMachine.add(2);


        List<Integer> moneyInput = new ArrayList<>();
        moneyInput.add(200);
        moneyInput.add(50);
        moneyInput.add(10);
        moneyInput.add(10);

        List<Integer> actual = Main.calculateChange(moneyInMachine, moneyInput, 254);

        List<Integer> expected= new ArrayList<>();
        expected.add(10);
        expected.add(2);
        expected.add(2);
        expected.add(1);
        expected.add(1);

        assertEquals(expected, actual);
    }

    @Test
    public void whenNotEnoughMoneyShouldReturnInputMoney() {

        List<Integer> moneyInMachine = new ArrayList<>();
        moneyInMachine.add(1);
        moneyInMachine.add(1);
        moneyInMachine.add(2);
        moneyInMachine.add(2);


        List<Integer> moneyInput = new ArrayList<>();
        moneyInput.add(200);
        moneyInput.add(50);
        moneyInput.add(10);
        moneyInput.add(10);

        List<Integer> actual = Main.calculateChange(moneyInMachine, moneyInput, 350);

        List<Integer> expected= new ArrayList<>();
        expected.add(200);
        expected.add(50);
        expected.add(10);
        expected.add(10);

        assertEquals(expected, actual);
    }
}