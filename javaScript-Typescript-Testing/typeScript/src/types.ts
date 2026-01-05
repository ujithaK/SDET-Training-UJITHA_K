
enum statuss {
  Active,
  Inactive,
  Pending
}

/**
 *  basic data types in TypeScript
 */
class BasicTypesDemo {

  // String type
  userName: string = "Ujitha";

  // Number type
  age: number = 22;
  salary: number = 45000.50;

  // Boolean type
  isActive: boolean = true;

  // Array types
  marks: number[] = [80, 85, 90];
  subjects: string[] = ["Math", "Science", "English"];

  // Tuple type
  employeeInfo: [number, string] = [101, "Rahul"];

  // Enum type
  userStatus: statuss = statuss.Active;

  // Any type
  randomValue: any = "Hello";

  /**
   * Method with void return type
   */
  displayDetails(): void {
    console.log("User Name:", this.userName);
    console.log("Age:", this.age);
    console.log("Salary:", this.salary);
    console.log("Active:", this.isActive);
    console.log("Marks:", this.marks);
    console.log("Subjects:", this.subjects);
    console.log("Employee Info:", this.employeeInfo);
    console.log("Status:", this.userStatus);
    console.log("Random Value:", this.randomValue);
  }
}

/**
 * Creating object and calling method
 */
const demo = new BasicTypesDemo();
demo.displayDetails();
