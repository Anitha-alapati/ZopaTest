package stepDefinitions;

import org.json.JSONObject;

import ZopaDTO.AddressDTO;
import ZopaDTO.NewZopaMemberRequestDTO;

import ZopaDTO.ZopaQuoteRequestDTO;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.RestAssured;

import io.restassured.response.Response;

public class ZopaQuoteUtils {
	
	public static String BASE_URL="https://qanat-quotes-public.staging.zopa.com/api";
	public static String RespString = "";
	public static String QuoteRespString = "";
	
    public static Response getRegisteredMember() {
   	
   	     Response response = RestAssured.given().log().all()
             .get(BASE_URL+"/member?memberId="+getMemberId());
   	     return response;    	
    }
        
    public static Response postNewMember() {
    	
    	NewZopaMemberRequestDTO newZopaMemberRequest = new NewZopaMemberRequestDTO();
    	AddressDTO add = new AddressDTO("47-49 Cottons Centre","London","SE1 2QG");
    	
    	newZopaMemberRequest.setFirstName("Zopa");
    	newZopaMemberRequest.setLastName("Test");
    	newZopaMemberRequest.setEmailAddress("test@gmail.com");
    	newZopaMemberRequest.setAddress(add);
    	newZopaMemberRequest.setJobTitle("job");
    	
    	 Response response = RestAssured.given().log().all()
                 .headers("Content-Type", "application/json")
                 .body(new Gson().toJson(newZopaMemberRequest))
                 .post(BASE_URL+"/member");
    	 RespString = response.asString();
    	 return response;
    	 
    }
    
    public static String getMemberId() {   
		JSONObject obj = new JSONObject(RespString);
	  	String member = obj.getString("memberId"); 
	  	System.out.println("Member ID:- - "+member);
	  	return member;
    }
	
	 public static Response postQuote(int CurrentSalary, int amountToBorrow, int termLength) throws Exception {
		 
		 ZopaQuoteRequestDTO zopaQuoteRequestDTO = new ZopaQuoteRequestDTO();
		 
		 zopaQuoteRequestDTO.setCurrentSalary(CurrentSalary);
		 zopaQuoteRequestDTO.setAmountToBorrow(amountToBorrow); 
		 zopaQuoteRequestDTO.setTermLength(termLength);
		 		
		 Response response = RestAssured.given().log().all()
                 .headers("Content-Type", "application/json")
                 .body(new Gson().toJson(zopaQuoteRequestDTO))
                 .post(BASE_URL+"/quote?memberId="+getMemberId());
		 QuoteRespString = response.asString();		 	 
		 return response;
		 
	 }
    
	 public static ZopaQuoteRequestDTO postQuotePrams(int CurrentSalary, int amountToBorrow, int termLength) throws Exception {
		 
		 ZopaQuoteRequestDTO zopaQuoteRequestDTO = new ZopaQuoteRequestDTO();
		 
		 zopaQuoteRequestDTO.setCurrentSalary(CurrentSalary);
		 zopaQuoteRequestDTO.setAmountToBorrow(amountToBorrow); 
		 zopaQuoteRequestDTO.setTermLength(termLength);
		 		
		 Response response = RestAssured.given().log().all()
                 .headers("Content-Type", "application/json")
                 .body(new Gson().toJson(zopaQuoteRequestDTO))
                 .post(BASE_URL+"/quote?memberId="+getMemberId());
		 QuoteRespString = response.asString();		 	 
		 return zopaQuoteRequestDTO;		 
	 }
	 
    public static Boolean getQuoteOffered() {
        
		JSONObject obj = new JSONObject(QuoteRespString);		
		Boolean quoteOffered = obj.getBoolean("quoteOffered");
	  	return quoteOffered;
    }
    
	 public static Response postWrongQuoteUrl(int CurrentSalary, int amountToBorrow, int termLength) throws Exception {
		 
		 ZopaQuoteRequestDTO zopaQuoteRequestDTO = new ZopaQuoteRequestDTO();
		 
		 zopaQuoteRequestDTO.setCurrentSalary(CurrentSalary);
		 zopaQuoteRequestDTO.setAmountToBorrow(amountToBorrow); 
		 zopaQuoteRequestDTO.setTermLength(termLength);
		 		
		 Response response = RestAssured.given().log().all()
                 .headers("Content-Type", "application/json")
                 .body(new Gson().toJson(zopaQuoteRequestDTO))
                 .post(BASE_URL+"/quote-memberId="+getMemberId());
		 return response;
		 
	 }
	
}
	

