package com.Vtiger.generic;

import com.github.javafaker.Faker;

public class TestData {

	/*
	 * author jyothi 
	 * this method will return name of the city
	 * @return String city name
	 */
	
	public String getFirstName()
	 {
		 Faker faker=new Faker();
		 String firstname=faker.name().firstName();
		 return firstname;
	 }
   public String getCityName()
   {
	   Faker faker=new Faker();
	   return faker.address().cityName();
	
}
   public String getPhoneNumber()
   {
	   Faker faker=new Faker();
	   String phonenumber=faker.phoneNumber().cellPhone();
	   return phonenumber;
	   
   }
   public String getProductName()
   {
	   Faker faker=new Faker();
	   String productname=faker.name().fullName();
	   return productname;
}
   public String getOrganizationName() {
		Faker faker=new Faker();
	String name  = faker.company().industry();
		return name;
	}
  public String getLastName() {
	  Faker faker=new Faker();
	  String lastname = faker.name().lastName();
	  return lastname;
  }


}