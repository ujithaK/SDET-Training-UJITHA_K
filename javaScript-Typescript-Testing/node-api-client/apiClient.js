const axios = require("axios");

const api = axios.create({
  baseURL: "https://jsonplaceholder.typicode.com",
  timeout: 5000
});

async function getUsers() {
  try {
    const response = await api.get("/users");
    return response.data;
  } catch (error) {
    throw new Error("Failed to fetch users");
  }
}

module.exports = { getUsers };


// File system operations

   const fs = require("fs"); 

    // Write File
    fs.writeFile("data.txt", "Hello Ujitha", err => {
    if (err) {
        console.error(err);
        return;
    }
    console.log("File written successfully");
    });

    // Read File
    fs.readFile("data.txt", "utf8", (err, data) => {
    if (err) throw err;
    console.log("File content:", data);
    });

    //Delete file
    await fs.unlink("data.txt");

    //Check files
    const fs = require("fs");

    if (fs.existsSync("data.txt")) {
    console.log("File exists");
    }

    //create directory
    await fs.mkdir("logs");


