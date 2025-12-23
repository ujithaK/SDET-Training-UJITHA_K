const { getUsers } = require("./apiClient");

async function main() {
  const users = await getUsers();
  console.log(users);
}

main();
