import { test, expect } from '@playwright/test';

test.describe('Visual Regression Testing - Single File Example', () => {

  test.beforeEach(async ({ page }) => {
    // Set consistent viewport (Best Practice)
    await page.setViewportSize({ width: 1280, height: 800 });

    // Disable animations to avoid flakiness
    await page.addStyleTag({
      content: `
        * {
          animation: none !important;
          transition: none !important;
        }
      `
    });
  });

  test('Homepage visual regression test', async ({ page }) => {


    //Implement Visual Test
    await page.goto('https://example.com');

    // Run Test and Compare Results
    await expect(page).toHaveScreenshot('homepage.png', {

      //Handle Acceptable Differences
    

      // Mask dynamic content
      mask: [
        page.locator('footer') // Example dynamic area
      ],

      // Allow small visual differences
      maxDiffPixelRatio: 0.01, // 1% tolerance

      // Capture full page screenshot
      fullPage: true
    });
  });

});
