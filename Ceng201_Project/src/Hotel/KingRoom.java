
package Hotel;

import java.io.Serializable;


public class KingRoom extends SuitRoom implements Serializable{
    private static final int MAX_CAPACITY = 8;
    private boolean electronicDoorLock;
    private boolean plusTicket;
    private boolean jacuzzi;

    
    
    
    public KingRoom(int roomNumber) {
        super(roomNumber);
        super.setRoomPrice(300);
        super.setRoomArea(calculateRoomArea());
        super.setRoomCapacity(MAX_CAPACITY);
        super.setRoomType("King Room");
        super.setRoomDecoration("Luxury Quality");
        this.electronicDoorLock = true;
        this.plusTicket = true;
        this.jacuzzi = true;
        
    }

   
    

    public static int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public boolean isElectronicDoorLock() {
        return electronicDoorLock;
    }

   

    public boolean isPlusTicket() {
        return plusTicket;
    }

 

    public boolean isJacuzzi() {
        return jacuzzi;
    }

    @Override
    int calculateRoomArea() {
        return MAX_CAPACITY*12;
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
        return super.toString() + "Electronic Door Lock: " + electronicDoorLock +
                "\nPlus Ticket=" + plusTicket + "\nJacuzzi: " + jacuzzi + "\n\n"; 
    }

    
   
    
}
