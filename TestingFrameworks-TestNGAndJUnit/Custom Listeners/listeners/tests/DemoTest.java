package listeners.tests;

import listeners.MyTestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//Used @Listeners annotation
@Listeners(MyTestListener.class)
public class DemoTest {

    @Test
    public void testPass() {
        System.out.println("Executing Pass Test");
        Assert.assertTrue(true);
    }

    @Test
    public void testFail() {
        System.out.println("Executing Fail Test");
        Assert.fail("Intentional Failure");
    }
}
