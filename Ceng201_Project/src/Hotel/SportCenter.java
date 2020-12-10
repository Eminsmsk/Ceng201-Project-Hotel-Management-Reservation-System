/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;

import java.util.ArrayList;

/**
 *
 * @author Emin
 */
public class SportCenter implements IFacilities{

    private double price = 10;

    @Override
    public String contents() {
       String cnt= "";
       cnt+="Showers"+"\n"+"Personal Trainer"+"\n"+"Plenty of Sport Staff for Every Muscle Group"+"\n"+"Clean and Big Pool";
        
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
           if(temp.get(i).isSportCenter())
             msg += "Room No: "+temp.get(i).getRoomNumber()+" Name: "+temp.get(i).getName()+" Surname: "+temp.get(i).getSurname()+"\n";
        }
        return msg;
    }
    
    
    
    
    
}
