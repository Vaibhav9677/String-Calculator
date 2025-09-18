# String Calculator
Implemented the String Calculator Kata in Java using Test-Driven Development (TDD) principles.
It is written in **plain Java** (no Maven/Gradle) and uses **JUnit 5** for testing.

---

## 📖 Problem Statement

String Calculator TDD Kata

```java
public int add(String numbers)

```
---

## 📂 Project Structure
StringCalculator/
│── src/
│ ├── StringCalculator.java # Main logic implementation
│ └── StringCalculatorTest.java # JUnit 5 test cases
│── lib/
│ └── junit-platform-console-standalone-<version>.jar # JUnit 5 standalone jar
│── README.md # documentation

---

## 📋 Prerequisites

Before running this project, make sure you have:

- **Java JDK 8+** installed ([Download here](https://www.oracle.com/java/technologies/javase-downloads.html))  
- **JUnit 5** standalone JAR (`junit-platform-console-standalone-<version>.jar`) placed in the `lib/` folder  
- A terminal/command prompt to compile and run Java programs 

---

## 📥 Clone the Repository

Clone String-Calculator using Git:

```bash
# Clone the repository
git clone https://github.com/Vaibhav9677/String-Calculator.git

# Move into the project folder
cd string_Calculator
```
----

## 📥 Compile & Run the Project

```bash
# Compile
javac -d out -cp lib/junit-platform-console-standalone-<version>.jar src/*.java
# Run 
java -jar lib/junit-platform-console-standalone-<version>.jar --class-path out --scan-class-path
```

---
## 🖥️ Output

When you run the tests, you should see output similar to this:

If all test cases passed :
```bash
Thanks for using JUnit! Support its development at https://junit.org/sponsoring

╷
├─ JUnit Jupiter ✔
│ ├─ StringCalculatorTest ✔
│ │ ├─ Empty string should return 0 ✔
│ │ ├─ String with number 1 and 2 ✔
│ │ ├─ Unknown amount of numbers should be summed ✔
│ │ ├─ Numbers separated by newlines should be summed ✔
│ │ ├─ Custom delimiter should be supported ✔
│ │ ├─ Negative number should throw exception with message ✔
│ │ ├─ Multiple negatives should show all in exception message ✔
│ │ ├─ how many times Add() was invoked ✔
│ │ ├─ Numbers bigger than 1000 should be ignored ✔
│ │ ├─ Delimiter of any length should be supported ✔
│ │ ├─ Multiple delimiters should be supported ✔
│ │ └─ Multiple delimiters with length longer than one char should be supported ✔
╵

Test run finished after 150 ms
[ 12 tests successful ]
[ 0 tests failed ]

```

If one or more test case failed : 

```
Test run finished after 150 ms
[ 10 tests successful ]
[ 2  tests failed ]
```

---

## 📝 Notes on TDD Workflow

This project follows the **Red ➝ Green ➝ Refactor** cycle of Test-Driven Development (TDD):

1. **Red** – Write a failing test (expected failure).
2. **Green** – Implement just enough code to make the test pass.
3. **Refactor** – Clean up code while keeping all tests passing.

To track progress, all test case results are stored in the `test_result/` directory.  
Each test is logged with its **test number** and outcome (Fail / Pass / Refactor).  
This helps visualize the evolution of the String Calculator step by step.  

✅ Example file structure inside `test_result/`:

## Authors

- [@vaibhav9677](https://www.github.com/vaibhav9677)