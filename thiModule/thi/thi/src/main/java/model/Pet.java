package model;

public class Pet {
    private int id ;
    private  TypePet typePet ;
    private String description;
    private String user ;

    public Pet() {
    }

    public Pet(int id, TypePet typePet, String description, String user) {
        this.id = id;
        this.typePet = typePet;
        this.description = description;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypePet getTypePet() {
        return typePet;
    }

    public void setTypePet(TypePet typePet) {
        this.typePet = typePet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
