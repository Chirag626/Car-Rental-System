package car_Rental_System_Project;

class Cars 
{
	private String carId;
	private String brand;
	private String Model;
	private double basePrice;
	private boolean isAvailable = true;
	
	public Cars(String carId,String brand,String Model,double basePrice)
	{
		this.carId = carId;
		this.brand = brand;
		this.Model = Model;
		this.basePrice = basePrice;
		
	}
	
	public String getCarId()
	{
		return carId;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return Model;
	}

	public double calculatePrice(int rentalDays) {
		return basePrice * rentalDays;
	}
	
	public boolean isAvailable()
	{
		return isAvailable;
	}
	
	public void rent()
	{
		isAvailable = false;
	}
	

	public void returnCar()
	{
		isAvailable = true;
	}

	@Override
	public String toString() {
		return "Cars [carId=" + carId + ", brand=" + brand + ", Model=" + Model + ", basePrice=" + basePrice
				+ ", isAvailable=" + isAvailable + "]";
	}
	
	
	
	
	}
