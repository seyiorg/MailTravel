package model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {

    String title;
    String FirstName;
    String LastName;
    String DOB_Day;
    String DOB_Month;
    String DOB_Year;
    String phone;
    String email;
    String address1;
    String address2;
    String city;
    String postcode;
    String country;
}
