
package Hotel;

import java.io.Serializable;


public class SuitRoom extends Room implements Serializable {
     private static final int MAX_CAPACITY = 5; 
     private boolean privateCase;
     private boolean dailyMeal;
     private boolean balcony;
     private boolean dailyRoomService;
     private boolean minibar;

    public SuitRoom(int roomNumber) {
        super("Suit Room",roomNumber, MAX_CAPACITY, "High Quality", 2);
        super.setRoomArea(calculateRoomArea());
        super.setRoomPrice(100);
        this.privateCase = true;
        this.dailyMeal = true;
        this.balcony = true;
        this.dailyRoomService = true;
        this.minibar = true;
    }

    @Override
    int calculateRoomArea() {
        return MAX_CAPACITY*10;
    }

    
      @Override
    double calculateRoomBill() {
       int num = super.getPresentCapacity();
       if(num==1){
           return super.getRoomPrice()*super.getReservedDays();
       }
       else if(num==2){
           return (super.getRoomPrice() + super.getRoomPrice()/2)*super.getReservedDays();
       }
       else{
           return super.getRoomPrice()*2*super.getReservedDays();
       }
       
    }
    

    
    public void setDailyMeal(boolean dailyMeal) {
        this.dailyMeal = dailyMeal;
    }

    public void setDailyRoomService(boolean dailyRoomService) {
        this.dailyRoomService = dailyRoomService;
    }

    public boolean isPrivateCase() {
        return privateCase;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public boolean isMinibar() {
        return minibar;
    }

    
    
    
    
    public static int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public boolean isDailyMeal() {
        return dailyMeal;
    }

    public boolean isDailyRoomService() {
        return dailyRoomService;
    }
    

    @Override
    public String toString() {
        return getRoomType() + "\n" + super.toString() + "Private Case: " + privateCase
                + "\nDaily Meal: " + dailyMeal + "\nBalcony: " + balcony + "\nDaily Room Service: " + dailyRoomService +"\nMinibar: " + minibar + "\n"; 
    }
     
     
     
}
