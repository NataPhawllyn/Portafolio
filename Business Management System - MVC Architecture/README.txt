Business Management System - MVC Architecture- JAVA

This project implements a business management system using the Model-View-Controller (MVC) design pattern in Java.
It includes functionalities for user management, product inventory, client registration, and invoice generation, 
providing a modular and scalable structure for further development.

Key Files
1. Model:  Define the core data structures and methods.
	 Classes:
		Administrador.java: Represents administrators with credentials and permissions.
		Cliente.java: Manages client details (e.g., ID, name, contact information).
		Factura.java: Handles invoice data, including itemized product lists and totals.
		Inventario.java: Tracks products, stock levels, and pricing.

2. View: Provide GUI components using Java Swing.

	RegistrarCliente.form: GUI for registering new clients.
	RegistrarProducto.form: GUI for adding products to inventory.
	MenuAdmin.form: Admin menu interface.
	MenuVendedor.form: Vendor menu interface.

3. Controller: Manage user interactions and connect the view to the model.

	Control.java:Handles action events from the GUI (e.g., button clicks). Validates user credentials, manages data operations, and updates views.
	Proyecto.java: Entry point of the application. Initializes the Control class and launches the main menu.

HOW TO RUN
Prerequisites
Java Development Kit (JDK) 11 or later.
Integrated Development Environment (IDE) like NetBeans or IntelliJ IDEA.

Compile the entire project, ensuring all classes are included.
Run the Proyecto class to launch the application.