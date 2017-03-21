/*
 * Copyright Denys Lebediev
 */
package danil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        // I changed something
        int x=a;
        int y=b;
        return x*y;
    }

    /**
     * @param n sequence length
     * @return fibonacci sequence of specified length. Sequence starts from 1, not 0.
     * @throws IllegalArgumentException if n is less than 2
     */
    public int[] fibonacci(int n)
    {
        int[] F = new int[n];
        F[0] = 1;
        F[1] = 1;
        for (int i = 2; i < n; i++){
            F[i] = F[i-1] + F[i-2];
        }
        return F;
    }

    /**
     * Finds missing integers in the array. Array is supposed to contain subsequent integers with the step of 1.
     * If any integer skipped then it is a missing integer. Examples: 1,2,3,5,6; 5,3,2,1 - 4 is missing in both cases.
     * Another example: 1,2,5 - 3 and 4 are missing.
     * Array MAY contain equal numbers. Examples: 1,2,2,2,3,3,4; 4,4,4,3,3,3; 1,1,1,1
     * @param numbers array of numbers, sorted acsending or descending
     * @return set of missing numbers
     * @throws IllegalArgumentException if array length is less than 2 or if array is not sorted
     */
    public Set<Integer> findMissingNumbers(int... numbers)
    {
        throw new UnsupportedOperationException("You implement this");
    }

    public int computeStringWidth(String s)
    {
        return s.length();
    }

    public String[] wrapString(String s, int w)
    {
        List<String> list = new ArrayList<>();

        StringBuilder currentSb = new StringBuilder();
        int i = 0;
        while (i < s.length())
        {
            int nextSpace = s.indexOf(' ', i);
            if (nextSpace == -1 || nextSpace-i > w)
            {
                currentSb.append(s.substring(i));
                i = s.length();
            }
            else
            {
                currentSb.append(s.substring(i, nextSpace+1));
                i = nextSpace+1;
            }
            if (currentSb.length() >= w)
            {
                if (currentSb.charAt(currentSb.length()-1) == ' ')
                {
                    currentSb.setLength(currentSb.length()-1);
                }
                list.add(currentSb.toString());
                currentSb.setLength(0);
            }
        }

        return list.toArray(new String[list.size()]);
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
