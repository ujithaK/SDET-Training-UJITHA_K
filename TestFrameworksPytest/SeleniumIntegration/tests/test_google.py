import pytest

@pytest.mark.ui
def test_google_title(browser):
    browser.get("https://www.google.com")
    assert "Google" in browser.title


@pytest.mark.ui
def test_search(browser):
    browser.get("https://www.google.com")

    search_box = browser.find_element("name", "q")
    search_box.send_keys("Chocolates")
    search_box.submit()

    assert "chocolate" in browser.title
