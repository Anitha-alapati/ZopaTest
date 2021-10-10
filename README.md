# ZopaTest

TestSetUp:

Clone the project url and open the project in Eclipse or Intellij IDEA 
Then we can see ZopaTest project

![image](https://user-images.githubusercontent.com/57220137/136711785-01a8511d-f6e4-4511-b5be-2f56807765e3.png)

From ZopaTest -> src/test/java, where we have stepDefinitions, testRunners and ZopaDTO packages and in src/test/resources -> features folder is where we can find zopaQuote.feature
In zopaQuote.feature there are test scenarios for ZopaQuoteApi endpoint

![image](https://user-images.githubusercontent.com/57220137/136712115-a1d75b46-050c-4029-991e-e5d6f71f4715.png)

There are @tags defined for the test scenarios like @positive, @negitive and @testQuoteApi, where we can run the test scenarios with the tags 
For example: if we want to run the positive scenarios (Test for the quoteOffer is true/false) give @positive tag in testRunners where tags="@positive" and run the test with JUnit test runner

![image](https://user-images.githubusercontent.com/57220137/136712569-7953f7ee-ffed-4529-b1c4-964a6b9a0d0c.png)



Service Test notes:

1. During the test I have noticed a few thing like conditions for quoteOffereds, if the amount is equal to 1000/25000 the the service is returning 400 status code and the error "message": "25000 is outside the lending range: 1000 <= TOTAL <= 25000". where the equals condition is failing for the service.

![image](https://user-images.githubusercontent.com/57220137/136713138-eee7602e-3e23-4993-880d-bdb18ddbf975.png)

![image](https://user-images.githubusercontent.com/57220137/136713148-40075d2a-250b-4caf-9b64-c19628d42e5b.png)

2. For the positive scenarios in the QuoteResponcseApi, for the field "membersFullName" is returning null. But in the previous GetMemberApi or PostNewMemberApi have the field "memberFullName" as firstName + lastName. I did not understand why/how this is part of AC ? or Is this a business requirement ?
 
![image](https://user-images.githubusercontent.com/57220137/136713420-93f11782-810a-4d4b-82fe-58e952ae9e97.png)

![image](https://user-images.githubusercontent.com/57220137/136713431-a9748910-ca1d-44fc-b1e8-b6bb5333c819.png)

3. During the testing process I got some random 503 responses, with the "message": The server is temporarily unable to service your request due to maintenance downtime or capacity problems. Please try again later. 
 
![image](https://user-images.githubusercontent.com/57220137/136713662-5d652f2a-2b26-4194-adfa-0372303fab8a.png)
