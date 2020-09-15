public class Person {
    private String frstName ;
    private String lastName;
    private int passportId ;
    public Person () {
        frstName="Имя";
        lastName="Фамилия";
        passportId=0;
    }
    public Person (String frstName,String lastName,int passportId){
        this.frstName=frstName;
        this.lastName=lastName;
        this.passportId=passportId;
    }
    public Person (String frstName,String lastName) {
        this.frstName=frstName;
        this.lastName=lastName;
    }

    public String getFrstName() {
        return frstName;
    }

    public void setFrstName(String frstName) {
        this.frstName = frstName;
    }
    public Person ( int passportId){
        this.passportId=passportId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

}

