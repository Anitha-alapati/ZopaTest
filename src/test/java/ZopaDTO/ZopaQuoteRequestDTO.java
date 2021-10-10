package ZopaDTO;

public class ZopaQuoteRequestDTO {
	
	private int currentSalary;
	private int amountToBorrow;
	private int termLength;
	
	public int getCurrentSalary() {  return currentSalary;  }

    public void setCurrentSalary(int currentSalary) { this.currentSalary = currentSalary; }
    
    public int getAmountToBorrow() {  return amountToBorrow;  }

    public void setAmountToBorrow(int amountToBorrow) {  this.amountToBorrow = amountToBorrow;  }
    
    public int getTermLength() {  return termLength;  }

    public void setTermLength(int termLength) {  this.termLength = termLength;  }

}
