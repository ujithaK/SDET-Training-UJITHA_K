import pytest

@pytest.mark.addition
def test_add():
    assert (7 + 3) == 10

@pytest.mark.multiplication
def test_product():
    assert 5 * 5 == 25

@pytest.mark.login
def test_login():
    assert "login successful"  

@pytest.mark.smoke
def test_smoke():
    assert True

@pytest.fixture
def sample_data():
    return {"id": 1, "name": "test-user"}

def test_fixture_usage(sample_data):
    assert sample_data["id"] == 1
