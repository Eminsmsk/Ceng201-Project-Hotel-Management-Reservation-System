
package Hotel;

import java.io.Serializable;


public abstract class  Person implements Serializable{
    private String name;
    private String surname;
    private String nationality;
    private String idNumber;
    private int age;
    private String type;
    

    public Person(String name, String surname, String nationality, String idNumber, int age, String type) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.idNumber = idNumber;
        this.age = age;
        this.type = type;
        
    }

    public String getIdNumber() {
        return idNumber;
    }

   

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNationality() {
        return nationality;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return  "Name: " + name + "\nSurname: " + surname + "\nNationality: " + nationality + "\nID: "
                + idNumber + "\nAge: " + age + "\n";
    }
    
    
    
    
    
    
    
    
}
