# Playwright vs Selenium – Comparison Project

## Objective
Automating the same test flow using Playwright and Selenium, comparing execution speed, stability, ease of scripting, and maintenance.

## Test Scenario
Application: https://demoqa.com/login  
Flow:
1. Launch browser
2. Navigate to login page
3. Enter username and password
4. Click Login
5. Validate successful login

## Tools Used
- Playwright (TypeScript)
- Selenium WebDriver (Java + TestNG)

## Execution Comparison

| Criteria | Playwright | Selenium |
|--------|------------|----------|
| Execution Speed | Faster | Slower |
| Stability | High (auto-wait) | Medium (manual waits) |
| Parallel Execution | Built-in | Selenium Grid required |

## Ease of Scripting & Maintenance

| Aspect | Playwright | Selenium |
|------|-----------|----------|
| Setup | Simple | Complex |
| Code Length | Short & clean | Verbose |
| Wait Handling | Automatic | Explicit waits |
| Maintenance | Low | High |

## Pros & Cons

### Playwright
**Pros**
- Auto-wait for elements
- Faster execution
- Built-in reports and parallel runs

**Cons**
- Newer tool
- Smaller ecosystem compared to Selenium

### Selenium
**Pros**
- Mature and stable
- Large community support
- Supports multiple languages

**Cons**
- Slower execution
- Manual wait handling
- More boilerplate code

## Conclusion
Playwright is better suited for modern, fast, and stable automation frameworks, while Selenium is ideal for legacy systems and projects requiring multi-language support.
