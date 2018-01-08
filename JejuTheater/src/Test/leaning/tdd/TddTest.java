package leaning.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static leaning.tdd.Money.DOLLOR;

public class TddTest {

    @Test
    public void testFirst() {

        Money oned = new Money(1, DOLLOR);
        Money twod = new Money(2, DOLLOR);

        Money result = oned.add(twod);

        Assert.assertTrue(
                result.equals(new Money(3, DOLLOR))
        );
    }

    @Test
    public void testMinus() {
        Money oned = new Money(1, DOLLOR);
        Money twod = new Money(2, DOLLOR);
        Money result = oned.add(twod);
        Assert.assertTrue(result.equals(new Money(3, DOLLOR)));
    }

}

class Money {
    public static String DOLLOR = "DOLLOR";
    private int value;
    private String currency;
    public Money(int value,
                 String currency
                 ) {
        this.value = value;
        this.currency = currency;
    }

    public Money add(Money target) {
        return new Money(this.value + target.value, DOLLOR);
    }

    @Override
    public boolean equals(Object o) {
        Money target = (Money)o;
        return this.value == target.value &&
                this.currency == target.currency
                ;
    }
}
