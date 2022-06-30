package model;

public class EmployeeBuilder {

    public Employee getEmp_A() {
        return Employee.builder()
                .title("Mr")
                .FirstName("Test")
                .LastName("Name")
                .DOB_Day("1")
                .DOB_Month("March")
                .DOB_Year("1980")
                .phone("00000000000")
                .email("test@test.com")
                .address1("Test Address")
                .address2("Test Address")
                .city("Test")
                .postcode("XX78XX")
                .country("Brazil")
                .build();
    }

    public Employee getEmp_B() {
        return Employee.builder()
                .title("Mr")
                .FirstName("Test2")
                .LastName("Name2")
                .DOB_Day("2")
                .DOB_Month("May")
                .DOB_Year("1990")
                .build();
    }
}
