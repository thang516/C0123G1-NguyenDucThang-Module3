package model;

public class Person {
    private String cccd ;
    private  String name ;
    private  String phoneNumber ;
    private  String userLogin ;

    public Person() {
    }

    public Person(String cccd, String name, String phoneNumber, String userLogin) {
        this.cccd = cccd;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.userLogin = userLogin;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}
