// Basic Data Types in TypeScript
// String
var fname = "Ujitha";
console.log("Name:", name);
// Number
var age = 25;
console.log("Age:", age);
// Boolean
var isStudent = true;
console.log("Is Student:", isStudent);
// Array
var scores = [90, 85, 70];
console.log("Scores:", scores);
var names = ["Alice", "Bob"];
console.log("Names:", names);
// Tuple
var personTuple = ["Alice", 30];
console.log("Person Tuple:", personTuple);
// Enum
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
var favoriteColor = Color.Green;
console.log("Favorite Color:", favoriteColor);
// Any
var randomValue = 10;
console.log("Random Value:", randomValue);
randomValue = "Hello";
console.log("Random Value Changed:", randomValue);
