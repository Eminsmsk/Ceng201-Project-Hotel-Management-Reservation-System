
package Hotel;

import java.util.ArrayList;

/**
 *
 * @author Emin
 */
public class Cinema implements IFacilities{
    private double price = 20;

    @Override
    public String contents() {
        String cnt= "Session is Everynight at 8pm.\n\n";
       cnt+="Monday: Irishman"+"\n"+"Tuesday: Ford v Ferrari"+"\n"+"Wednesday: Godfather"+"\n"+"Thursday: The Green Mile\n"+"Friday: John Wick\n"
               +"Saturday: Detachment\n"+"Sunday: The Revenant\n";
        
        return cnt;
        
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String display() {
       String msg = "";
        ArrayList<Guest> temp = SystemClass.getGuests();
        for (int i = 0; i < temp.size(); i++) {
           if(temp.get(i).isCinema())
             msg += "Room No: "+temp.get(i).getRoomNumber()+" Name: "+temp.get(i).getName()+" Surname: "+temp.get(i).getSurname()+"\n";
           
        }
        return msg;
    }
    
    
}
