/*
 * Copyright Denys Lebediev
 */
package danil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denis Lebedev
 */
public class Calculator
{
    public int sum(int a, int b)
    {
        return a+b;
    }

    public int mult(int a, int b)
    {
        return a*b;
    }

    public int computeStringWidth(String s)
    {
        return s.length();
    }

    public String[] wrapString(String s, int w)
    {
        throw new UnsupportedOperationException("You implement this");
    }

    public static void main(String[] args)
    {
        Calculator c = new Calculator();
        String[] s = c.wrapString("aaaa aa bb bbbb", 7);
        for (int i=0; i<s.length; i++)
        {
            System.out.println(s[i]);
        }
    }
}
