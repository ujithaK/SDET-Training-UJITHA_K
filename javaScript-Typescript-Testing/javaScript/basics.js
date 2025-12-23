// Variables & DataTypes

    let firstName="ujitha"    
    let lastName="kalvakunta"
    const fullName="ujitha Kalvakunta"
    let name = "Ujitha";     // String
    let age = 22;           // Number
    let isActive = true;    // Boolean
    let x = null;           // Null
    let y;                  // Undefined
    let id = Symbol("id");  // Symbol



    console.log(typeof(firstName));   //this code type of data
    console.log(typeof(lastName));
    console.log(`My name is ${firstName} ${lastName} and my age is ${age}`);



//  Functions and arrow functions
    
   //Addition using general function
    function add(a,b){
    console.log("Sum : "+ (a+b));
    
    }
    add(10,20)
    

    //Subtraction using arrow function
    let sub=(a,b)=>{
         return a-b;
    }
    console.log("Subtraction : " + sub(20,10))
    
    let details=(fname,age)=>{
        return `my name is ${fname} and my age is ${age}`
    }

    console.log(details("ujitha",22));


    // Objects

    let user={
        fname:"ujitha",
        lname:"kalvakunta",
        age:22,
        loc:"Bangalore"
    }

    console.log(user.fname);
    console.log(user.lname);
    console.log(user.age);
    console.log(user.loc);

    //Arrays

    let numbers=[1,2,3,4,5,6,7,8,9,10]

    console.log(numbers);
    console.log("5th index number from numbers array is : "+numbers[5]);


    // Control flow

    let validAge=17;
    //  if else:
    if(validAge>=18){
        console.log("Eligible for voting");
        
    }else{
        console.log("Not eligible for voting");
        
    }
     //else if

     let score = 85;

    if (score > 90) {
    console.log("Section A");
    } else if (score > 75) {
    console.log("Section B");
    } else {
    console.log("Section C");
    }

    //switch
    let day=1

    switch(day){
        case 1:
            console.log("Monday");
            break
        case 2:
            console.log("Tuesday");
            break
        case 3:
            console.log("Wednesday");
            break
        case 4:
            console.log("Thursday");
            break
        case 5:
            console.log("Friday");
            break
        case 6:
            console.log("Saturday");
            break
        case 7:
            console.log("Sunday");
            break
                
    }

    //loops

    //for loop
     for(let i=1;i<=10;i++){
        console.log(i);
     }

    //while loop
     let n=5
     while(n>0){
       console.log(n);
      n--;    
     }
 
    // for each
    for(let nums of numbers){
        console.log(nums);    
    }



    
    
    
    
