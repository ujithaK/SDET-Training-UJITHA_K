class Animal {
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

const dog = new Animal("Buddy", 3);
dog.speak(); 


//inheritance
class Dog extends Animal {
  breed: string;

  constructor(name: string, age: number, breed: string) {
    super(name, age);
    this.breed = breed;
  }

  speak(): void {
    console.log(`${this.name} barks.`);
  }
}

const myDog = new Dog("Max", 4, "Labrador");
myDog.speak(); 
