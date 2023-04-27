package model;

public class Customer {
        private  String name;
        private  String  dateOfBirth;
        private  String address;
        private  String photos;

    public Customer() {
    }

    public Customer(String name, String dateOfBirth, String address, String photos) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.photos = photos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
}
