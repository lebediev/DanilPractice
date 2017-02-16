/*
 * Copyright Denys Lebediev
 */
package danil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Denis Lebedev
 */
public class CalculatorTest extends Assert
{
    private Calculator calculator_;

    @Before
    public void setUp()
    {
        calculator_ = new Calculator();
    }

    @Test
    public void testSum()
    {
        int s1 = calculator_.sum(1, 3);
        assertEquals(4, s1);

        assertEquals(0, calculator_.sum(-1, 1));

        assertEquals(-2, calculator_.sum(-1, -1));
    }

    @Test
    public void testMult()
    {
        int m1 = calculator_.mult(1, 3);
        assertEquals(3, m1);

        int m2 = calculator_.mult(0, 1);
        assertEquals(0, m2);

        assertEquals(-2, calculator_.mult(-1, 2));
    }

    @Test
    public void testComputeStringWidth()
    {
        assertEquals(5, calculator_.computeStringWidth("Hello"));
    }

    @Test
    public void testWrapString()
    {
        assertArrayEquals(new String[]{"aa aa aa", "bb bb bb", "cc cc cc"}, calculator_.wrapString("aa aa aa bb bb bb cc cc cc ", 8));

        assertArrayEquals(new String[]{"aaaa aa", "bb bbbb"}, calculator_.wrapString("aaaa aa bb bbbb", 7));

        assertArrayEquals(new String[]{"aaaa"}, calculator_.wrapString("aaaa", 3));

        assertArrayEquals(new String[]{"aa", "bbbb cc"}, calculator_.wrapString("aa bbbb cc", 3));
    }

}
