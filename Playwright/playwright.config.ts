import { defineConfig, devices } from '@playwright/test';

/**
 * Playwright Test Configuration
 * https://playwright.dev/docs/test-configuration
 */
export default defineConfig({

  // Directory where test files are located
  testDir: './tests',

  // Run test files in parallel
  fullyParallel: true,

  // Fail the build if test.only is left in CI
  forbidOnly: !!process.env.CI,

  // Retry failed tests only on CI
  retries: process.env.CI ? 2 : 0,

  // Limit workers on CI, use default locally
  workers: process.env.CI ? 1 : undefined,

  // Generate HTML report after execution
  reporter: 'html',

  // Shared settings for all browsers
  use: {
    // Take screenshot only when test fails
    screenshot: 'only-on-failure',

    // Record video and keep only for failed tests
    video: 'retain-on-failure',

    // Capture trace on first retry of a failed test
    trace: 'on-first-retry',
  },

  // Browser configuration
  projects: [

    {
      name: 'chromium',
      use: { ...devices['Desktop Chrome'] },
    },

    {
      name: 'firefox',
      use: { ...devices['Desktop Firefox'] },
    },

    {
      name: 'webkit',
      use: { ...devices['Desktop Safari'] },
    },

    // -------- Optional (Commented) --------

    // Mobile Chrome
    // {
    //   name: 'Mobile Chrome',
    //   use: { ...devices['Pixel 5'] },
    // },

    // Mobile Safari
    // {
    //   name: 'Mobile Safari',
    //   use: { ...devices['iPhone 12'] },
    // },

    // Microsoft Edge
    // {
    //   name: 'Microsoft Edge',
    //   use: { ...devices['Desktop Edge'], channel: 'msedge' },
    // },

    // Google Chrome
    // {
    //   name: 'Google Chrome',
    //   use: { ...devices['Desktop Chrome'], channel: 'chrome' },
    // },
  ],

  // Optional: Start local server before tests
  // webServer: {
  //   command: 'npm run start',
  //   url: 'http://localhost:3000',
  //   reuseExistingServer: !process.env.CI,
  // },

});
