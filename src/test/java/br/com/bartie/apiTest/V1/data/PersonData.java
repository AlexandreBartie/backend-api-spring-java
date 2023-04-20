package br.com.bartie.apiTest.V1.data;

public class PersonData {

    public static String getFirstName(Long id)
    { return "FirstName#" + id; }

    public static String getLastName(Long id)
    { return "LastName#" + id; }

    public static String getAddress(Long id)
    { return "Address#" + id; }
   
    public static String getGender(Long id)
    { return ((id % 2)==0) ? "Male" : "Female"; }
    
}
