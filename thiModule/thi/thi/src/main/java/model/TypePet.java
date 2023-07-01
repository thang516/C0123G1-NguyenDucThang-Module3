package model;

public class TypePet {
    private  int  idPet;
    private  String namePet ;

    public TypePet() {
    }

    public TypePet(int idPet, String namePet) {
        this.idPet = idPet;
        this.namePet = namePet;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }
}
