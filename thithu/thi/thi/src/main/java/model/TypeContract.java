package model;

public class TypeContract {
    private int idContract ;
    private String contractName;

    public TypeContract() {
    }

    public TypeContract(int idContract, String contractName) {
        this.idContract = idContract;
        this.contractName = contractName;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
}
