import pytest

# Session scope fixture (runs once for entire test run)
@pytest.fixture(scope="session")
def start_app():
    print("Starting application")
    yield
    print("Stopping application")


# Module scope fixture (runs once per test file)
@pytest.fixture(scope="module")
def connect_db():
    print("Connecting to database")
    yield
    print("Disconnecting database")


# Class scope fixture (runs once per class)
@pytest.fixture(scope="class")
def login_user():
    print("Logging in user")
    user = {"username": "ujitha"}
    yield user
    print("Logging out user")


# Function scope fixture (runs before each test)
@pytest.fixture(scope="function")
def setup_env():
    print("Setting up environment")
    env = {"env": "testing"}
    yield env
    print("Cleaning environment")

#Using pytest -v -s for testing