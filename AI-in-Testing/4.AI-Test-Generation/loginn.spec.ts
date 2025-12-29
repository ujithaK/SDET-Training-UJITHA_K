import { test, expect } from '@playwright/test';

test.describe('AI Generated Login Test Scenarios', () => {

  const APP_URL = 'https://opensource-demo.orangehrmlive.com'; // ✅ demo app

  const validUser = {
    username: 'Admin',
    password: 'admin123'
  };

  const invalidUser = {
    username: 'wronguser',
    password: 'wrongpass'
  };


  // 1. Login with valid credentials
  test('Login with valid credentials', async ({ page }) => {
    await page.goto(APP_URL);

    await page.getByPlaceholder('Username').fill(validUser.username);
    await page.getByPlaceholder('Password').fill(validUser.password);
    await page.getByRole('button', { name: 'Login' }).click();

    await expect(page).toHaveURL(/dashboard/);
  });

 
  // 2. Login with invalid credentials
  test('Login with invalid credentials', async ({ page }) => {
    await page.goto(APP_URL);

    await page.getByPlaceholder('Username').fill(invalidUser.username);
    await page.getByPlaceholder('Password').fill(invalidUser.password);
    await page.getByRole('button', { name: 'Login' }).click();

    await expect(
      page.locator('.oxd-alert-content-text')
    ).toContainText('Invalid credentials');
  });


  // 3. Login with empty fields
  test('Login with empty fields shows validation', async ({ page }) => {
    await page.goto(APP_URL);

    await page.getByRole('button', { name: 'Login' }).click();

    await expect(
      page.locator('.oxd-input-group__message')
    ).toContainText('Required');
  });

 
  // 4. Session cookie created after login
  test('Session should be created after successful login', async ({ page, context }) => {
    await page.goto(APP_URL);

    await page.getByPlaceholder('Username').fill(validUser.username);
    await page.getByPlaceholder('Password').fill(validUser.password);
    await page.getByRole('button', { name: 'Login' }).click();

    const cookies = await context.cookies();
    expect(cookies.length).toBeGreaterThan(0);
  });

  
  // 5. Logout functionality
  test('Logout should redirect to login page', async ({ page }) => {
    await page.goto(APP_URL);

    await page.getByPlaceholder('Username').fill(validUser.username);
    await page.getByPlaceholder('Password').fill(validUser.password);
    await page.getByRole('button', { name: 'Login' }).click();

    await page.getByAltText('profile picture').click();
    await page.getByText('Logout').click();

    await expect(page).toHaveURL(/login/);
  });

});
