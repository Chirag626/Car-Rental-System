package car_Rental_System_Project;
public class Rental
{
	private Customer customer;
	private Cars car;
	private int Days;
	
	public Rental(Cars car,Customer customer,int Days)
	{
		this.car = car;
		this.customer = customer;
		this.Days = Days;
	}
	
	public Cars getCar()
	{
		return car;
	}
	public Customer getCustomer()
	{
		return customer;	
	}
	public int getRentingDay()
	{
		return Days;
	}
}
