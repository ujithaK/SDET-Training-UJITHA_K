"use strict";
//Datatypes
let namee = "Ujitha";
let age = 22;
let isActive = true;
//Arrya
let scores = [10, 20, 30];
let names = ["A", "B"];
//function
function log() {
    console.log("Hello");
}
const user = {
    id: 1,
    name: "Ujitha",
    email: "ujitha@test.com"
};
// class
class Person {
    constructor(name) {
        this.name = name;
    }
    greet() {
        console.log(`Hello ${this.name}`);
    }
}
const p = new Person("Ujitha");
p.greet();
//Access MOdifiers
class Employee {
    constructor(name, salary, role) {
        this.name = name;
        this.salary = salary;
        this.role = role;
    }
}
//javascript code 
// function add(a, b) {
// return a + b;
// }
// Typescript code
function add(a, b) {
    return a + b;
}
async function getUsers() {
    const res = await fetch("");
    return res.json();
}
