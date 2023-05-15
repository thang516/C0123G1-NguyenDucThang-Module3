package model;

public class TypeContract {
    private  int idContract ;

    private  String  nameContract;
    public TypeContract() {
    }

    public TypeContract(int idContract, String nameContract) {
        this.idContract = idContract;
        this.nameContract = nameContract;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public String getNameContract() {
        return nameContract;
    }

    public void setNameContract(String nameContract) {
        this.nameContract = nameContract;
    }
}
