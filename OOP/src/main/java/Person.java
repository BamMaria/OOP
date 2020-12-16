public class Person {
    private String frstName ;
    private String lastName;
    private int passportId ;
    private Gender gender;

    Gender getGender() {
        return gender;
    }

    void setGender(Gender gender) {
        this.gender = gender;
    }
    Person () {
        frstName="Имя";
        lastName="Фамилия";
        passportId=0;
    }
     Person (String frstName,String lastName,int passportId){
        this.frstName=frstName;
        this.lastName=lastName;
        this.passportId=passportId;
    }
    public Person (String frstName,String lastName) {
        this.frstName=frstName;
        this.lastName=lastName;
    }

     String getFrstName() {
        return frstName;
    }

    void setFrstName(String frstName) {
        this.frstName = frstName;
    }
    Person ( int passportId){
        this.passportId=passportId;
    }

     String getLastName() {
        return lastName;
    }

     void setLastName(String lastName) {
        this.lastName = lastName;
    }

     int getPassportId() {
        return passportId;
    }

     void setPassportId(int passportId) {
        this.passportId = passportId;
    }



    @Override
    public String toString() {
        return this.frstName + " " + this.lastName;
    }

}

