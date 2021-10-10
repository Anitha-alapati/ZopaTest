package ZopaDTO;

public class AddressDTO {
	
	private String type;
	private String firstLine;
	private String town;
	private String postCode;
	
	
	public AddressDTO(String firstLine, String town, String postCode) {
		
		this.type = "Address";
		this.firstLine = firstLine;
		this.town = town;
		this.postCode = postCode;
		
	}

	public String getType() { return type; }
	
	public void setType(String type) {  this.type = type; }
	
	public String getFirstLine() { return firstLine; }
	
	public void setFirstLine(String firstLine) { this.firstLine = firstLine; }
	
    public String getTown() { return town; }
	
	public void setTown(String town) { this.town = town; }
	
    public String getPostCode() { return postCode; }
	
	public void setPostCode(String postCode) { this.postCode = postCode; }
	
}
