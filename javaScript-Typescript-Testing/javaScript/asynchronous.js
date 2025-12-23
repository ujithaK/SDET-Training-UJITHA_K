//Callback function
   let nums=[10,30,20,40]
   let arr=nums.map((ele)=>{
      console.log(ele);
      
   })

   let arrSort=nums.sort((a,b)=>{
    return a-b;
   })
   console.log(arrSort);

//Promises
  let res=new Promise((res,rej)=>{
    let state=true
    if(state){
        res("Fullfilled")
    }
    else{
        rej("Rejected")
    }
  })
  console.log(res);
   
  res.then(result=>console.log(result)
  ).catch(result=>console.log(result)
  )

  //async & await

    function getData() {
    return new Promise(resolve => {
        setTimeout(() => resolve("Data received"), 2000); 
    });
    }

    async function fetchData() {
    const result = await getData();
    console.log(result);
    }

    fetchData();

//Error handling using try-catch

    async function fetchUser() {
    try {
        const data = await getData();
        console.log(data);
    } catch (error) {
        console.error("Error:", error);
    }
    }


    //fetching data using then catch
fetch("https://jsonplaceholder.typicode.com/users")
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error(error));


  //fetching data using async and awai
  async function getUsers() {
  try {
    const response = await fetch("https://jsonplaceholder.typicode.com/users");
    const users = await response.json();
    console.log(users);
  } catch (error) {
    console.error("Failed to fetch users");
  }
}

getUsers();


