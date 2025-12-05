import pytest

@pytest.mark.smoke
def test_login():
    assert 10 == 10

@pytest.mark.regression
def test_add():
    assert 5 + 3 == 8

@pytest.mark.skip(reason="Skipping this test temporarily")
def test_skip_demo():
    assert 1 == 2

@pytest.mark.xfail(reason="Known issue , need to be fixed")
def test_unstable():
    assert 1 == 2
