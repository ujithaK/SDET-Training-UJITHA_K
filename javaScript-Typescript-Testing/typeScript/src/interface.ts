// 1. Interface Example
interface Person {
  name: string;
  age: number;
  isStudent?: boolean; // optional property
}


// 2. Type Alias Example


type Point = {
  x: number;
  y: number;
};

const point: Point = { x: 10, y: 20 };
console.log("Point:", point);

// 3. Union Type Example

type ID = string | number;

let userId: ID = 101;
console.log("User ID (number):", userId);

userId = "ABC123";
console.log("User ID (string):", userId);


// 4. Extending Interface

interface Employee extends Person {
  employeeId: number;
}
