// basic_types.ts

// String
let fname: string = "Ujitha";
console.log("Name:", fname);

// Number
let age: number = 25;
console.log("Age:", age);

// Boolean
let isStudent: boolean = true;
console.log("Is Student:", isStudent);

// Array
let scores: number[] = [90, 85, 70];
console.log("Scores:", scores);

// Interface (object with type)
interface Person {
  name: string;
  age: number;
}

const student: Person = {
  name: "Alice",
  age: 22,
};
console.log("Student:", student);

// Class with types
class Animals {
  name: string;
  age: number;

  constructor(name: string, age: number) {
    this.name = name;
    this.age = age;
  }

  speak(): void {
    console.log(`${this.name} makes a sound.`);
  }
}

const dogs = new Animal("Buddy", 3);
dog.speak();
