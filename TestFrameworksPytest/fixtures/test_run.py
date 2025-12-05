def test_flow_one(start_app, connect_db, login_user, setup_env):
    print("Running Test Flow 1")

    assert login_user["username"] == "ujitha"
    assert setup_env["env"] == "testing"


def test_flow_two(connect_db, setup_env):
    print("Running Test Flow 2")

    assert setup_env["env"] == "testing"
