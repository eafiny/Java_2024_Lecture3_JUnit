import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.muctr.SimpleMethods;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;

/**
 * @author Evgenia Skichko
 */
public class SimpleMethodsTest {
    private double delta = 1E-6;
    private static ByteArrayOutputStream output = new ByteArrayOutputStream();
    static SimpleMethods object;

    @BeforeClass
    public static void setUpOutputStream(){
        object = new SimpleMethods();
        System.out.println("BeforeClass");
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testConsole(){
        object.printConsole();
        Assert.assertEquals("Working", output.toString());
    }

    @Test
    public void testSum(){
        Assert.assertEquals(5, object.sum(2,3));
    }

    //0.05 эквивалентно 0.0500001?
    @Test
    public void testSumDouble(){
        Assert.assertEquals(5, object.sumDouble(2.01,3), delta);
    }

    @Test(expected = ArithmeticException.class)
    public void methodShouldThrowException(){
        object.division(5,0);
    }


    //**************** Тесты с Assert.assertThat ********************************************************
    @Test
    public void stringShouldContainSubstring(){
        Assert.assertThat(SimpleMethods.getSomeString(), containsString("New"));
    }

    @Test
    public void stringShouldEqualAnotherString(){
        Assert.assertThat(SimpleMethods.getSomeString(), equalTo("New String"));
    }

    //Для того чтобы использовать матчеры greaterThan, lessThan, lessThanOrEqualTo и др.,
    // нужно подключить в pom-файл зависимость hamcrest-all
    @Test
    public void sumShouldBeMoreThan10AndLessThan20(){ //
        Assert.assertThat(object.sum(10,2),
                allOf(greaterThan(10), lessThan(20)));
    }

    @AfterClass
    public static void CleanUpOutput(){
        System.setOut(null);
    }
}
