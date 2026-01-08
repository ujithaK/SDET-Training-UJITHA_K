import { test, expect } from '@playwright/test';

test('Shopify Sauce Demo Signup Form Automation', async ({ page }) => {

  await page.goto('https://sauce-demo.myshopify.com/account/register');

  // signup form fields 
  await page.locator('input[name="customer[first_name]"]').fill('Ujitha');
  await page.locator('input[name="customer[last_name]"]').fill('Yuzu');

  await page.locator('input[name="customer[email]"]').fill('ujitha@gmail.com');

  await page.locator('input[name="customer[password]"]').fill('ujitha@123');

  // Submit form
  await page.getByRole('button', { name: /Create/i }).click();

});
