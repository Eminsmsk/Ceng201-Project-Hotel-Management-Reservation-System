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
public class DiningHall implements IFacilities{

    private double price = 30;
   
    @Override
    public String contents() {
       String cnt= "";
       cnt+="Monday"+"\n-------------\n"+"Breakfast: "+"Olives, Cheese, Eggs, Jams, Tahini-Molasses"+"\n"+"Dinner: "
               +"Soup, Stuffed peppers with meat, Yogurt, Potato salad, Dessert\n\n";
       cnt+="Tuesday"+"\n-------------\n"+"Breakfast: "+"Olives, Cheese, Eggs, Jams, Peanut butter"+"\n"+"Dinner: "
               +"Soup, Meatball, Yogurt, Potato salad, Dessert\n\n";
       cnt+="Wednesday"+"\n-------------\n"+"Breakfast: "+"Olives, Cheese, Eggs, Jams, Puff pastry"+"\n"+"Dinner: "
               +"Soup, Fish, Yogurt, Potato salad, Dessert\n\n";
       cnt+="Thursday"+"\n-------------\n"+"Breakfast: "+"Olives, Cheese, Eggs, Jams, Anzer honey"+"\n"+"Dinner: "
               +"Soup, Chicken with souce, Yogurt, Potato salad, Dessert\n\n";
       cnt+="Friday"+"\n-------------\n"+"Breakfast: "+"Olives, Cheese, Eggs, Jams, Patty"+"\n"+"Dinner: "
               +"Stuffed peppers with meat, Yogurt, Potato salad, Dessert\n\n";
       cnt+="Saturday"+"\n-------------\n"+"Breakfast: "+"Olives, Cheese, Eggs, Jams, Muhlama "+"\n"+"Dinner: "
               +"Soup, Adana Kebab, Yogurt, Potato salad, Dessert\n\n";
       cnt+="Sunday"+"\n-------------\n"+"Breakfast: "+"Olives, Cheese, Eggs, Jams, French fries"+"\n"+"Dinner: "
               +"Soup, Iskender, Yogurt, Potato salad, Dessert\n\n";
        
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
            if(temp.get(i).isDiningHall())
             msg += "Room No: "+temp.get(i).getRoomNumber()+" Name: "+temp.get(i).getName()+" Surname: "+temp.get(i).getSurname()+"\n";
           
        }
        return msg;
    }
    
    
    
}
