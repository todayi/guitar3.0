package Model;

public class Guitar {
	private Integer id ;

	private String serialNumber;
	private double price;
	private GuitarSpec guitarSpec;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public GuitarSpec getGuitarSpec() {
		return guitarSpec;
	}
	public void setGuitarSpec(GuitarSpec guitarSpec) {
		this.guitarSpec = guitarSpec;
	}
	
}
