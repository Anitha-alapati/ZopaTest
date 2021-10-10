package ZopaDTO;

public class NewZopaMemberRequestDTO {
	
	private String firstName;
	private String lastName;
	private AddressDTO address;
	private String emailAddress;
	private String jobTitle;
	
	public String getFirstName() {  return firstName;  }

    public void setFirstName(String firstName) {  this.firstName = firstName;  }
    
    public String getLastName() {  return lastName;  }

    public void setLastName(String lastName) {  this.lastName = lastName;  }
    
    public AddressDTO getAddress() { return address; }
    
    public void setAddress(AddressDTO address) { this.address = address; }
    
    public String getEmailAddress() {  return emailAddress;  }

    public void setEmailAddress(String emailAddress) {  this.emailAddress = emailAddress;  }
    
    public String getJobTitle() {  return jobTitle;  }

    public void setJobTitle(String jobTitle) {  this.jobTitle = jobTitle;  } 

}
