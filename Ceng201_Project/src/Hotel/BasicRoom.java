
package Hotel;

import java.io.Serializable;


public class BasicRoom extends Room implements Serializable{
    private static final int MAX_CAPACITY = 3;

    public BasicRoom(int roomNumber) {
        super("Basic Room",roomNumber, MAX_CAPACITY,"Basic Quality", 1);
        super.setRoomArea(calculateRoomArea());
        super.setRoomPrice(50);
    }
    
    
    
    public static int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    @Override
    int calculateRoomArea() {
        return MAX_CAPACITY*8;
        
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
    

    @Override
    public String toString() {
        return getRoomType()+"\n"+super.toString(); 
    }


    
    
   
    
    
    
}
