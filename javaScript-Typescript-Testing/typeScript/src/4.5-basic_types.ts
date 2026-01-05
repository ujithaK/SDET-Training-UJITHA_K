// Basic Data Types in TypeScript

// String
let fname: string = "Ujitha";
console.log("Name:", name);

// Number
let age: number = 25;
console.log("Age:", age);

// Boolean
let isStudent: boolean = true;
console.log("Is Student:", isStudent);

// Array
let scores: number[] = [90, 85, 70];
console.log("Scores:", scores);

let names: string[] = ["Alice", "Bob"];
console.log("Names:", names);

// Tuple
let personTuple: [string, number] = ["Alice", 30];
console.log("Person Tuple:", personTuple);

// Enum
enum Color { Red, Green, Blue }
let favoriteColor: Color = Color.Green;
console.log("Favorite Color:", favoriteColor);

// Any
let randomValue: any = 10;
console.log("Random Value:", randomValue);
randomValue = "Hello";
console.log("Random Value Changed:", randomValue);
