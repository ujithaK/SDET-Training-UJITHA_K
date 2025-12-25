import { test, expect } from '@playwright/test';

test.describe('Playwright Starter Example', () => {

  test('Basic page validation test', async ({ page }) => {

    // 1. Navigate to the application
    await page.goto('https://example.com');

    // 2. Validate page title
    await expect(page).toHaveTitle('Example Domain');

    // 3. Validate heading text
    const heading = page.locator('h1');
    await expect(heading).toHaveText('Example Domain');

    // 4. Click on a link (More Information)
    await page.click('text=More information');

    // 5. Validate navigation
    await expect(page).toHaveURL(/iana.org/);
  });

});
