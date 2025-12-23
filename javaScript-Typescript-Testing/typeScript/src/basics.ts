//Datatypes

let namee: string = "Ujitha";
let age: number = 22;
let isActive: boolean = true;
 //Arrays
let scores: number[] = [10, 20, 30];
let names: Array<string> = ["A", "B"];

//function

function log(): void {
  console.log("Hello");
}


// interfaces

interface User {
  id: number;
  name: string;
  email: string;
}

const user: User = {
  id: 1,
  name: "Ujitha",
  email: "ujitha@test.com"
};

// types
    type Status = "active" | "inactive";

    type Product = {
    id: number;
    name: string;
    price: number;
    };


    // class

    class Person {
    name: string;

    constructor(name: string) {
        this.name = name;
    }

    greet(): void {
        console.log(`Hello ${this.name}`);
    }
    }

    const p = new Person("Ujitha");
    p.greet();

    //Access MOdifiers

    class Employee {
    public name: string;
    private salary: number;
    protected role: string;

    constructor(name: string, salary: number, role: string) {
        this.name = name;
        this.salary = salary;
        this.role = role;
    }
    }

     

    // Typescript code & Run this command to convert the typeScript code into javascript code :- npx tsc 
  function add(a: number, b: number): number {
    return a + b;
  }



  interface User {
    id: number;
    name: string;
  }

async function getUsers(): Promise<User[]> {
  const res = await fetch("");
  return res.json();
}








