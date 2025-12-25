import { test, expect } from '@playwright/test';

test.describe('API Testing with Playwright', () => {

  // SEND API REQUESTS USING PLAYWRIGHT API

  test('GET API - Fetch users', async ({ request }) => {

    const response = await request.get('https://reqres.in/api/users?page=2');

    //VALIDATE RESPONSE STATUS & BODY

    expect(response.status()).toBe(403);

    const responseBody = await response.json();

    expect(responseBody.page).toBe(2);
    expect(responseBody.data.length).toBeGreaterThan(0);

    // Validate one user object
    expect(responseBody.data[0]).toHaveProperty('id');
    expect(responseBody.data[0]).toHaveProperty('email');

    console.log(responseBody);
  });

  // POST API REQUEST + VALIDATION

  test('POST API - Create user', async ({ request }) => {

    const response = await request.post('https://reqres.in/api/users', {
      data: {
        name: 'Ujitha',
        job: 'QA Engineer'
      }
    });

    expect(response.status()).toBe(201);

    const responseBody = await response.json();

    expect(responseBody.name).toBe('Ujitha');
    expect(responseBody.job).toBe('QA Engineer');
    expect(responseBody).toHaveProperty('id');
    expect(responseBody).toHaveProperty('createdAt');

    console.log(responseBody);
  });

  //  MOCK & INTERCEPT NETWORK CALLS

  test('Mock API response', async ({ page }) => {

    await page.route('**/api/users?page=1', async route => {
      await route.fulfill({
        status: 200,
        contentType: 'application/json',
        body: JSON.stringify({
          page: 1,
          data: [
            {
              id: 101,
              email: 'uji@test.com',
              first_name: 'uji',
              last_name: 'ujitha'
            }
          ]
        })
      });
    });

    await page.goto('https://reqres.in');

    // Trigger API call (example via fetch)
    const response = await page.evaluate(async () => {
      const res = await fetch('https://reqres.in/api/users?page=1');
      return res.json();
    });

    expect(response.data[0].first_name).toBe('uji');
    expect(response.data[0].email).toBe('uji@test.com');

    console.log(response);
  });

});
