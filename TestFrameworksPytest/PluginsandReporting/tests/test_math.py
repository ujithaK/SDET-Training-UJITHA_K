import pytest

@pytest.mark.smoke
def test_addition():
    assert 2 + 3 == 5

@pytest.mark.regression
def test_multiplication():
    assert 4 * 5 == 20

@pytest.mark.regression
def test_division():
    assert 10 / 2 == 5
