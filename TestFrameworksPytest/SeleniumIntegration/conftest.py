import pytest
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
import os

# FIXTURE: Setup + Teardown WebDriver
@pytest.fixture
def browser(request):

    options = Options()
    options.add_argument("--start-maximized")

    driver = webdriver.Chrome(options=options)
    driver.implicitly_wait(10)

    yield driver   # Test runs here

    # TAKE SCREENSHOT ON FAILURE
    if request.node.rep_call.failed:
        screenshot_dir = "screenshots"
        os.makedirs(screenshot_dir, exist_ok=True)

        file_name = request.node.name + ".png"
        file_path = os.path.join(screenshot_dir, file_name)
        driver.save_screenshot(file_path)

        # Attach screenshot to pytest-html report
        if request.config.getoption("--html"):
            extra = getattr(request.config, "extra", [])
            extra.append(pytest_html.extras.image(file_path))
            request.config.extra = extra

    driver.quit()


# HOOK: Track test results(responisible for taking screenshots when test fails)
@pytest.hookimpl(hookwrapper=True)
def pytest_runtest_makereport(item, call):
    outcome = yield
    rep = outcome.get_result()

    if rep.when == "call":
        item.rep_call = rep
