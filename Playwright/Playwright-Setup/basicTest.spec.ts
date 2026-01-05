import { test, expect } from '@playwright/test';

test.describe('Playwright Starter Example', () => {

  test('Basic page validation test', async ({ page }) => {

    // 1. Navigate to the application
    await page.goto('https://sauce-demo.myshopify.com');

    // 2. Validate page title
    await expect(page).toHaveTitle('Sauce Demo');

  
    // 3. Click on the "Log In" link (if exists)
    await page.click('text=Log in');

    // 4. Validate navigation URL contains "account"
    await expect(page).toHaveURL(/account/);

  });

});
