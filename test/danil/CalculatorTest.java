/*
 * Copyright Denys Lebediev
 */
package danil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
    public void testFibonacci()
    {
        int[] s;
        s = calculator_.fibonacci(11);
        assertEquals(s[8], s[10]-s[9]);
        assertEquals(s[0], s[2]-s[1]);
        assertEquals(s[1], s[3]-s[2]);

        s = calculator_.fibonacci(798);
        assertEquals(s[795], s[797]-s[796]);
        assertEquals(s[321], s[323]-s[322]);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testFibonacciException1()
    {
        calculator_.fibonacci(1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testFibonacciException0()
    {
        calculator_.fibonacci(0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testFibonacciException_1()
    {
        calculator_.fibonacci(-1);
    }

    @Test
    public void testFindMissingNumbers()
    {
        assertEquals(Collections.emptySet(), calculator_.findMissingNumbers(1,1));
        assertEquals(Collections.emptySet(), calculator_.findMissingNumbers(1,1,1));
        assertEquals(Collections.emptySet(), calculator_.findMissingNumbers(1,2));
        assertEquals(Collections.emptySet(), calculator_.findMissingNumbers(1,2,3));
        assertEquals(Collections.emptySet(), calculator_.findMissingNumbers(2,1));
        assertEquals(Collections.emptySet(), calculator_.findMissingNumbers(3,2,1));
        assertEquals(Collections.emptySet(), calculator_.findMissingNumbers(1,1,2,2));
        assertEquals(Collections.emptySet(), calculator_.findMissingNumbers(2,2,1,1));

        assertEquals(setOf(3,5,7), calculator_.findMissingNumbers(2,4,6,8,9,10,11));
        assertEquals(setOf(1), calculator_.findMissingNumbers(2,0));
        assertEquals(setOf(4), calculator_.findMissingNumbers(2,2,2,2,3,3,3,3,3,5));
        assertEquals(setOf(4,5), calculator_.findMissingNumbers(6,6,6,6,6,3,3,3,3,3));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testFindMissingNumbersExceptionShortArray()
    {
        calculator_.findMissingNumbers(1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testFindMissingNumbersExceptionUnsorted1()
    {
        calculator_.findMissingNumbers(1,2,3,4,5,4,3,2,1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testFindMissingNumbersExceptionUnsorted2()
    {
        calculator_.findMissingNumbers(10,11,12,7,6,5);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testFindMissingNumbersExceptionUnsorted3()
    {
        calculator_.findMissingNumbers(3,3,3,4,4,4,4,4,7,7,7,7,7,5,5,5,5);
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

    private static Set<Integer> setOf(int... ints)
    {
        Set<Integer> s = new HashSet<>();
        for (int i : ints)
        {
            s.add(Integer.valueOf(i));
        }
        return s;
    }

}
