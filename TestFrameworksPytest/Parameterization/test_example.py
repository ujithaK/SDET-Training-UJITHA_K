import pytest
import json
import os



# Load external test data (JSON)
def load_external_data():
    file_path = os.path.join(os.path.dirname(__file__), "data.json")
    with open(file_path, "r") as f:
        return json.load(f)

external_data = load_external_data()



# Fixture that gets a parameterized value
@pytest.fixture(params=[10, 20, 30])
def number_fixture(request):
    return request.param


# Test using @pytest.mark.parametrize
@pytest.mark.parametrize(
    "a, b, expected",
    [
        (2, 3, 5),
        (10, 5, 15),
        (-1, 1, 0),
    ]
)
def test_addition(a, b, expected):
    assert a + b == expected



# Test that uses parameterized fixture + test params
@pytest.mark.parametrize("increment", [1, 2, 3])
def test_fixture_with_param(number_fixture, increment):
    result = number_fixture + increment
    assert result > number_fixture


# Test using data  from external JSON file (data.json)
@pytest.mark.parametrize("item", external_data)
def test_external_data(item):
    # Expect every record to have a result = a + b
    assert item["a"] + item["b"] == item["result"]
