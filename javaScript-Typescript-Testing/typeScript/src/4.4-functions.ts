function add(a: number, b: number): number {
  return a + b;
}

let result: number = add(5, 10);

// TS
interface Person {
  name: string;
  age: number;
}

let person: Person = { name: "Alice", age: 25 };
