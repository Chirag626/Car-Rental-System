package car_Rental_System_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car_Rental_System 
{
	private List<Cars> car;
	private List<Customer>customers;
	private List<Rental> rentals;
	
	public Car_Rental_System()
	{
		// 3 blank arraylist are created in memory.
		car = new ArrayList<>();
		customers = new ArrayList<>();
		rentals = new ArrayList<>();
	}
	
	public void addCar(Cars c)
	{
		// now add car details in array list.
		car.add(c);
	}
	
	public void addCustomers(Customer cust)
	{
		// add customer details in array list.
		customers.add(cust);
	}
	
	public void addRent(Rental r)
	{
		// add rental details in array list.
		rentals.add(r);
	}
	
	
	public void rentCar(Cars car, Customer customer,int days)
	{
		if(car.isAvailable())
		{
			car.rent();
			rentals.add(new Rental(car,customer,days));
		}
		else
		{
			System.out.println("Car is not Available for Rent ");
		}
		
	}
	
	public void returnCars(Cars car)
	{
		car.returnCar();
		
		Rental rentToRemove = null;
		for(Rental  r : rentals)
		{
			if(r.getCar() == car)
			{
				rentToRemove = r;
				break;
			}
		}
		
		if(rentToRemove != null)
		{
			rentals.remove(rentToRemove);
			
			System.out.println("Car Returned Successfully.");
		}
		else
		{
			System.out.println("Car was not returned.");
		}
	}
	
	public void Menu() {
	    Scanner sc = new Scanner(System.in);

	    while (true) {
	        System.out.println("==== Car Rental System ====");
	        System.out.println("1. Rent a Car");
	        System.out.println("2. Return a Car");
	        System.out.println("3. Exit");

	        System.out.print("\nEnter Your Choice: ");
	        int choice = sc.nextInt();
	        sc.nextLine(); // Consume the newline character left by nextInt()

	        if (choice == 1) {
	            System.out.println("\n==== Rent A Car ====");
	            System.out.print("Enter Your Name: ");
	            String customerName = sc.nextLine();

	            System.out.print("Enter Your Mobile Number: ");
	            long number = sc.nextLong();
	            sc.nextLine(); // Consume the newline character

	            System.out.print("Enter Your Address: ");
	            String address = sc.nextLine();

	            int newCustomerId = customers.size() + 1;

	            System.out.println("\n=== Available Cars ===");
	            for (Cars c : car) {
	                if (c.isAvailable()) {
	                    System.out.println(c);
	                }
	            }

	            System.out.print("\nEnter the Car Id you want to Rent: ");
	            String carId = sc.nextLine();

	            System.out.print("Enter the Number of Days you want to Rent: ");
	            int rentalDays = sc.nextInt();
	            sc.nextLine(); // Consume the newline character

	            Customer newCustomer = new Customer(newCustomerId, customerName, number, address);
	            addCustomers(newCustomer);

	            Cars selectedCar = null;
	            for (Cars s : car) {
	                if (s.getCarId().equals(carId) && s.isAvailable()) {
	                    selectedCar = s;
	                    break;
	                }
	            }

	            if (selectedCar != null) {
	                double totalPrice = selectedCar.calculatePrice(rentalDays);
	                System.out.println("\n==== Rental Information ====");
	                System.out.println("Customer Id: " + newCustomer.getCustomerId());
	                System.out.println("Customer Name: " + newCustomer.getCName());
	                System.out.println("Customer Phone No.: " + newCustomer.getPhone());
	                System.out.println("Customer Address: " + newCustomer.getAddress());
	                System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
	                System.out.println("Rental Days: " + rentalDays);
	                System.out.printf("Total Price: $%.2f%n", totalPrice);

	                System.out.print("Confirm (Y/N): ");
	                String confirmation = sc.nextLine();

	                if (confirmation.equalsIgnoreCase("Y")) {
	                    rentCar(selectedCar, newCustomer, rentalDays);
	                    System.out.println("Car rented successfully.\n");
	                } else {
	                    System.out.println("Rental cancelled.\n");
	                }
	            } else {
	                System.out.println("Invalid car selection or car not available for rent.\n");
	            }

	        } else if (choice == 2) {
	            System.out.println("\n=== Return A Car ===");
	            System.out.print("Enter the Car Id you want to Return: ");
	            String carId = sc.nextLine();

	            Cars carToReturn = null;
	            for (Cars r : car) {
	                if (r.getCarId().equals(carId) && !r.isAvailable()) {
	                    carToReturn = r;
	                    break;
	                }
	            }

	            if (carToReturn != null) {
	                Customer customer = null;
	                for (Rental rent : rentals) {
	                    if (rent.getCar().equals(carToReturn)) {
	                        customer = rent.getCustomer();
	                        break;
	                    }
	                }

	                if (customer != null) {
	                    returnCars(carToReturn);
	                    System.out.println("Car returned successfully by " + customer.getCName());
	                } else {
	                    System.out.println("Car was not rented or rental information is missing.");
	                }
	            } else {
	                System.out.println("Invalid car Id or car is not rented.");
	            }

	        } 
	        else if (choice == 3)
	        {
	        	System.out.println("Are You Really Want to Exit (Y/N) : ");
	        	String confirm = sc.next();
	        	if(confirm.equalsIgnoreCase("Y"))
	        	{
	        		System.out.println("Thank you for using the Car Rental System.");
	        		break;	        		
	        	}
	        	else
	        	{
	        		Menu();
	        	}
	        } 
	        else 
	        {
	            System.out.println("Invalid choice. Please enter a valid option.");
	        }
	    }
	    sc.close();
	}
}
