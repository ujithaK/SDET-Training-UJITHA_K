import { test } from '@playwright/test';
import { Eyes, ClassicRunner } from '@applitools/eyes-playwright';

test('Visual test with Applitools', async ({ page }) => {
  const runner = new ClassicRunner();
  const eyes = new Eyes(runner);

  try {
    await eyes.open(page, 'My App', 'Home Page Test');
    await page.goto('https://example.com');

    await eyes.checkWindow('Home Page');
    await eyes.close();
  } finally {
    const results = await runner.getAllTestResults();
    console.log(results);
  }
});
