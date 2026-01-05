import { test, expect } from '@playwright/test';
import fs from 'fs';
import path from 'path';

const screenshotDir = path.join(__dirname, 'screenshots');
if (!fs.existsSync(screenshotDir)) fs.mkdirSync(screenshotDir);

test('Complete Login Flow Automation with Multiple Tabs, Screenshots & Videos', async ({ page, context }) => {

  // 1. Navigate to the website
  await page.goto("https://www.saucedemo.com/");

  // 2. Fill login form
  await page.locator('#user-name').fill("standard_user");
  await page.locator('#password').fill("secret_sauce");
  await page.getByRole('button', { name: 'Login' }).click();

  // 3. Verify successful login
  await expect(page).toHaveURL(/inventory/);
  await expect(page.getByText('Products')).toBeVisible();

  // 4. Take screenshot after login
  await page.screenshot({
    path: path.join(screenshotDir, 'login-success.png'),
    fullPage: true
  });

  // 5. Handle multiple tabs/pages
  const [newPage] = await Promise.all([
    context.waitForEvent('page'),
    page.evaluate(() => window.open('https://www.saucedemo.com/')) // opens new tab
  ]);

  // Wait for new tab to load
  await newPage.waitForLoadState();

  //  Verify title of new tab
  await expect(newPage).toHaveTitle('Swag Labs');

  // Take screenshot of new tab
  await newPage.screenshot({
    path: path.join(screenshotDir, 'new-tab.png')
  });

  // Close new tab
  await newPage.close();

});
