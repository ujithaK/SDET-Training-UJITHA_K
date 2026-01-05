// basic_types.ts
// String
var fname = "Ujitha";
console.log("Name:", fname);
// Number
var age = 25;
console.log("Age:", age);
// Boolean
var isStudent = true;
console.log("Is Student:", isStudent);
// Array
var scores = [90, 85, 70];
console.log("Scores:", scores);
var student = {
    name: "Alice",
    age: 22,
};
console.log("Student:", student);
// Class with types
var Animals = /** @class */ (function () {
    function Animals(name, age) {
        this.name = name;
        this.age = age;
    }
    Animals.prototype.speak = function () {
        console.log("".concat(this.name, " makes a sound."));
    };
    return Animals;
}());
var dogs = new Animal("Buddy", 3);
dogs.speak();
