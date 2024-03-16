import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.muctr.SimpleMethods;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Evgenia Skichko
 */

@RunWith(Parameterized.class)
public class ParameterizedTestClass {
    int a;
    int b;
    int sum;

    public ParameterizedTestClass(int a, int b, int sum) {
        this.a = a;
        this.b = b;
        this.sum = sum;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
//                {new int[]{2,3,4},3,5},
                {2,3,5},
                {10,20,30},
                {1,2,10}
        });
    }
    @Test
    public void testSum(){
        SimpleMethods object = new SimpleMethods();
        Assert.assertEquals(sum, object.sum(a,b));
    }
}
