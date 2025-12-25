import { test, expect } from '@playwright/test';

test.describe('Login Test - Playwright', () => {

  test('User should login successfully', async ({ page }) => {

    // 1. Navigate
    await page.goto('https://demoqa.com/login');

    // 2. Enter credentials
    await page.fill('#userName', 'ujitha');
    await page.fill('#password', 'uji@123');

    // 3. Click Login
    await page.click('#login');

    // 4. Assertion
    await expect(page.locator('#userName-value')).toBeVisible();
  });

});
