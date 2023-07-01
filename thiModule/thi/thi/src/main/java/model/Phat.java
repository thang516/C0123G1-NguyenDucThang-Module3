package model;

public class Phat {
    private  int phatId ;
    private  String user ;
    private int id ;
    private String information ;
    private String dateTime ;
    private  String money ;
    private String note ;

    public Phat() {
    }

    public Phat(int phatId, String user, int id, String information, String dateTime, String money, String note) {
        this.phatId = phatId;
        this.user = user;
        this.id = id;
        this.information = information;
        this.dateTime = dateTime;
        this.money = money;
        this.note = note;
    }

    public Phat(String user, int id, String information, String dateTime, String money) {
        this.user = user;
        this.id = id;
        this.information = information;
        this.dateTime = dateTime;
        this.money = money;


    }

    public int getPhatId() {
        return phatId;
    }

    public void setPhatId(int phatId) {
        this.phatId = phatId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
