package model;

public class Contract {
    private  int id ;
    private String name ;
    private TypeContract typeContract ;
    private  String dateStart ;
    private  String dateEnd ;

    public Contract() {
    }

    public Contract(int id, String name, TypeContract typeContract, String dateStart, String dateEnd) {
        this.id = id;
        this.name = name;
        this.typeContract = typeContract;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Contract(String name, TypeContract typeContract, String dateStart, String dateEnd) {
        this.name = name;
        this.typeContract = typeContract;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeContract getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(TypeContract typeContract) {
        this.typeContract = typeContract;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
