
package Hotel;


public class Staff extends Person{
    private String username;
    private String password;

    public Staff(String username, String password, String name, String surname, String nationality, String idNumber, int age) {
        super(name, surname, nationality, idNumber, age, "Staff Member");
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    
    
}
