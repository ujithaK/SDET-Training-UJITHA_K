package dependencies;

import org.testng.annotations.Test;

public class DependencyTest {

    @Test
    public void loginTest() {
        System.out.println("Login Test");
        // int x = 1/0;  // uncomment to simulate failure
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void dashboardTest() {
        System.out.println("Dashboard Test");
    }

    @Test(groups = "smoke")
    public void openBrowser() {
        System.out.println("Browser Opened");
    }

    @Test(dependsOnGroups = {"smoke"})  //it depends on smoke group tests
    public void runAfterSmokeGroup() {
        System.out.println("Runs After Smoke Group");
    }

    @Test(dependsOnMethods = {"loginTest"}, alwaysRun = true)
    public void cleanupTest() {
        System.out.println("Cleanup Test (Always Runs)");
    }
}
