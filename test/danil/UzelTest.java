/*
 * Copyright Denys Lebediev
 */
package danil;

import org.junit.Test;
import org.junit.Assert;

/**
 * @author Denis Lebedev
 */
public class UzelTest
{
    @Test
    public void testPath()
    {
        Uzel u1 = new Uzel(1);
        Uzel u2 = new Uzel(2);
        Uzel u3 = new Uzel(3);
        //TODO Uzel u4 = new Uzel(4);

        u1.setToArr(u2);
        u2.setToArr(u3);
        //u3.setToArr(u4);

        Assert.assertTrue(u1.hasPathTo(2));

        Assert.assertTrue(u1.hasPathTo(3));

        //Assert.assertTrue(u1.hasPathTo(3));
    }

}
