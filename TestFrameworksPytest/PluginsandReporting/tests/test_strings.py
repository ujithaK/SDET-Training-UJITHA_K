import pytest

@pytest.mark.smoke
def test_uppercase():
    assert "hello".upper() == "HELLO"

@pytest.mark.regression
def test_isdigit():
    assert "123".isdigit()

@pytest.mark.smoke
def test_concatenation():
    assert "Py" + "Test" == "PyTest"
