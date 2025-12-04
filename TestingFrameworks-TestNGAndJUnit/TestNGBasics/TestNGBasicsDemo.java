

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestNGBasicsDemo {

    // SUITE Annotations
    @BeforeSuite
    public void beforeSuite() {
        System.out.println(" BEFORE SUITE - Runs only once (first) in entire suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AFTER SUITE - Runs only once (last) in entire suite");
    }


    // TEST LEVEL Annotations
    @BeforeTest
    public void beforeTest() {
        System.out.println("BEFORE TEST - Run once before <test> block in XML");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AFTER TEST - Run once after <test> block in XML");
    }


    //CLASS LEVEL Annotations
    @BeforeClass
    public void beforeClass() {
        System.out.println(" BEFORE CLASS - Run once before class is loaded");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(" AFTER CLASS - Run once after class execution ends");
    }


    //  METHOD LEVEL
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BEFORE METHOD - Runs before each @Test method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AFTER METHOD - Runs after each @Test method\n");
    }


    // TEST METHODS

    @Test
    public void testLoginHardAssert() {
        System.out.println("Running testLoginHardAssert()");

        // HARD ASSERT (Stops execution if it fails)
        String actualTitle = "Dashboard";
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle, expectedTitle,
                "Hard Assert Failed: Titles do not match!");

        System.out.println("Expected and Results are matched");
    }


    @Test
    public void testSoftAssertions() {
        System.out.println("Running testSoftAssertions()");

        SoftAssert soft = new SoftAssert();

        soft.assertEquals("Hello", "Hi", "String mismatch!");
        soft.assertTrue(false, "Condition is false!");
        soft.assertEquals(10, 20, "Values not equal!");

        System.out.println("Soft asserts collected. Test continues...");

        // Must call assertAll() at end
        soft.assertAll();
    }


    @Test
    public void testSearch() {
        System.out.println("Running testSearch()");
        Assert.assertTrue(true);
    }


    @Test
    public void testLogout() {
        System.out.println("Running testLogout()");
        Assert.assertTrue(true);
    }

}
