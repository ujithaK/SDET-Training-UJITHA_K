import { test, expect } from '@playwright/test';

test('Self-healing locator POC', async ({ page }) => {
  await page.goto('https://the-internet.herokuapp.com/login');

  const locators = [
    page.getByRole('button', { name: /login/i }),
    page.locator('button[type="submit"]'),
    page.getByText(/login/i),
    page.locator('input[type="submit"]'),
  ];

  let clicked = false;

  for (const locator of locators) {
    try {
      await locator.first().waitFor({ timeout: 3000 });
      await locator.first().click();
      console.log('Clicked using:', locator.toString());
      clicked = true;
      break;
    } catch {
      console.log('Locator failed:', locator.toString());
    }
  }

  expect(clicked).toBeTruthy();
});
