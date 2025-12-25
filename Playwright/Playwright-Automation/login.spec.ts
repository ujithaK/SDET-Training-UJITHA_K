import { test, expect } from '@playwright/test';

test('Login Flow Automation',async({page,context})=>{
    //this will go to the website
    await page.goto("https://www.saucedemo.com/")

    // it'll find the username field and fill the data
    await page.locator('#user-name').fill("standard_user")

    //it'll find the password field and fill the data(which we are passing)
    await page.locator('#password').fill("secret_sauce")

    await page.getByRole('button', { name: 'Login' }).click();

     await expect(page).toHaveURL(/inventory/);
  await expect(page.getByText('Products')).toBeVisible();


  // Take screenshot after successful login
  await page.screenshot({
    path: 'screenshots/login-success.png',
    fullPage: true
  });

  // HANDLE MULTIPLE TABS / PAGES


  // Click a link that opens a new tab (example link)
  const [newPage] = await Promise.all([
    context.waitForEvent('page'),
    page.evaluate(() => window.open('https://example.com'))
  ]);

  // Wait for new tab to load
  await newPage.waitForLoadState();

  // Verify title of new tab
  await expect(newPage).toHaveTitle(/Example Domain/);

  // Take screenshot of new tab
  await newPage.screenshot({
    path: 'screenshots/new-tab.png'
  });

  // Close new tab
  await newPage.close();
});
