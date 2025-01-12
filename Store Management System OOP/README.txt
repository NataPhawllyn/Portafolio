Store Management System

This project is a Store Management System designed to handle product sales, 
maintain an organized record of transactions, and generate sales reports. 
Built using Java, the system uses Object-Oriented Programming 
(OOP) principles to ensure modularity and scalability.


System Structure
1. Classes
_*Factura.java: Represents an invoice for a product sale.
	Attributes:
		codigoProducto: The product code.
		fecha: The sale date.
		cantidad: Quantity sold.
		codigoVendedor: Code of the seller handling the sale.
	Methods:
	Getters for product code and quantity.

-*Venta.java: Manages a collection of invoices for a specific product and day.
	Attributes:
		facturas: A list of Factura objects.
	Methods:
		registrarFactura: Adds a new invoice to the list.
		Getters and setters for the invoice list.

_*Tienda.java:  Core class managing the store's operations, including sales registration and reporting.
	Attributes:
		Arrays for products, sellers, and days of the week.
		A matrix (registroVentas) to store sales data organized by product and day.
	Methods:
		registrarFacturaDeVenta: Adds a sale to the matrix with user input.
		consultarVentasDia: Displays total sales for a given day.
		consultarVentasProducto: Displays total sales for a specific product.
		eliminarFacturasVentasEscasas: Removes invoices with low sales volumes.
		Interactive menu for accessing system functionalities.

HOW TO RUN 

compile using  Java  bash codes 

