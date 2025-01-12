Bookstore Management System
This project is a Bookstore Management System, designed to manage a collection of books with functionalities such as adding, updating, and selling books. It is implemented in Java and leverages object-oriented programming principles to ensure modularity and ease of maintenance.

Features
-*Add Books: Allows the user to add a new book with details like ISBN, title, and price.
-*Add Units to a Book: Increases the quantity of available units for a specific book.
-*Remove a Book: Deletes a book from the collection.
-*Reorganize Books: Changes the position of a book within the collection.
-*Sell Books: Updates the sold quantity of a book and reduces its available units accordingly.

Code Structure
1. Classes
-*Libros (Books)
Represents a book with attributes such as ISBN, title, price, available quantity, and sold quantity.
Provides getter and setter methods to manage book data.
Includes a toString method to display detailed book information.

-*Lista (List)
Manages a dynamic list of books using arrays (lista and listaAux).
Offers methods to add, display, and manage books in the list.
Implements resizing and copying functionality to handle changes in the collection dynamically.

-*Proyecto2_NeiraCruz
The main class that provides a menu-based interface for user interaction.
Integrates user input and coordinates functionality between Libros and Lista classes.

2. Key Concepts
Object-Oriented Programming (OOP)

-*Encapsulation: Private attributes with getter and setter methods in Libros.
-*Modularization: Separate responsibilities into Libros, Lista, and Proyecto2_NeiraCruz classes.

Dynamic Array Management

-*Uses auxiliary arrays (listaAux) to dynamically manage the collection of books, allowing for flexible resizing.
Control Structures

Conditional statements (if, switch) handle logic for menu options.
-*Loops dynamically adjust the size of arrays and manage book operations.

User Interaction

Captures and processes user input via the Scanner class.

HOW TO RUN
Ensure you have a Java Development Kit (JDK) installed on your system.
Compile the files using the javac command and run the main class.

