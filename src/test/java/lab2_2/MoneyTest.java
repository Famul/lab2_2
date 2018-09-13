package lab2_2;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Currency;

import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

    @Test
    public void moneyMultiplyingShouldReturnCorrectValue() {
        Money testMoney1 = new Money(5);
        double multiplier = 32.5;
        Money correctValue = new Money(162.5);
        assertThat(testMoney1.multiplyBy(multiplier), equalTo(correctValue));
    }

    @Test
    public void addingMoneyShouldReturnCorrectValue() {
        Money testMoney1 = new Money(15.4);
        Money testMoney2 = new Money(53.24);
        Money testMoney3 = new Money(648.91);
        Money correctValue = new Money(717.55);
        assertThat(testMoney1.add(testMoney2).add(testMoney3), equalTo(correctValue));
    }

    @Test
    public void substractingMoneyShouldReturnCorrectValue() {
        Money testMoney1 = new Money(15.4);
        Money testMoney2 = new Money(3.24);
        Money correctValue = new Money(12.16);
        assertThat(testMoney1.subtract(testMoney2), equalTo(correctValue));
    }

    @Test
    public void addingMoneyWithDifferentCurrenciesShouldReturnException() {
        Money testMoney1 = new Money(15.4);
        Money testMoney2 = new Money(53.24, Currency.getInstance("PLN"));
        Money testMoney3 = new Money(648.91);
        try {
            testMoney1.add(testMoney2).add(testMoney3);
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), equalTo("Currency mismatch"));
            Assert.assertEquals(e.getClass(), IllegalArgumentException.class);
        }
    }

    @Test
    public void substractingMoneyWithDifferentCurrenciesShouldReturnException() {
        Money testMoney1 = new Money(15.4);
        Money testMoney2 = new Money(53.24, Currency.getInstance("PLN"));
        try {
            testMoney1.subtract(testMoney2);
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), equalTo("Currency mismatch"));
            Assert.assertEquals(e.getClass(), IllegalArgumentException.class);
        }
    }
}
