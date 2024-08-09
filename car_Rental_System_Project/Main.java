package car_Rental_System_Project;
public class Main {

	public static void main(String[] args) 
	{
		Car_Rental_System rentalSystem = new Car_Rental_System();
		
		 Cars car1 = new Cars("C001","THAR","Mahindra",150); 
		 Cars car2 = new Cars("C002","TATA - Harrier","TATA",160); 
		 Cars car3 = new Cars("C003","Rolls-Royce","BMW",500); 
		 Cars car4 = new Cars("C004","Audi","Volkswagen",350); 
		 
		 rentalSystem.addCar(car1);
		 rentalSystem.addCar(car2);
		 rentalSystem.addCar(car3);
		 rentalSystem.addCar(car4);
		 
		 rentalSystem.Menu();
	}

}

