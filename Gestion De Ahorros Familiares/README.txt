Family Savings Calculator
This project, titled Family Savings Calculator, calculates the total savings for the Neira family for a specific month by collecting their income and expenses. It provides a user-friendly interface to input values and displays the computed results.

Features
-*Income Input: Allows the user to input multiple income entries for the family.
-*Expense Input: Collects multiple expense entries for accurate calculations.
-*Savings Calculation: Computes the total savings as the difference between total income and total expenses.
-*Summary Display: Displays the final income, expenses, and computed savings.

Code Structure
1. Classes
-*FliaNeira (Family Neira)

Represents the family’s financial details with attributes for income, expenses, and savings.
Includes methods for setting and retrieving values (set and get methods).
Implements the method gananciaTotal to compute savings as income - expenses.
Overrides toString to display a summary of financial data.

-*Main

The main class orchestrates user input and calculations.
Uses a Scanner to collect income and expense data in a loop.
Displays the final results using the toString method of FliaNeira.

2. Key Concepts

Object-Oriented Programming (OOP)

-*Encapsulation: Private attributes in FliaNeira are accessed through getter and setter methods.
-*Modularization: Responsibilities are divided between FliaNeira (data handling) and Main (logic and interaction).

Control Structures

-*Loops (for) are used to iteratively collect income and expense data.
-*Basic arithmetic operations are performed to compute savings.

User Interaction

-*Prompts the user to input data interactively via the console.

Build Tool

-*The project uses Apache Maven for build and dependency management.

HOW TO RUN

Ensure you have a Java Development Kit (JDK) installed on your system.
Compile the files using the javac command and run the main class.


Prerequisites

Java Development Kit (JDK) 11 or later.
Apache Maven for building and running the project.

