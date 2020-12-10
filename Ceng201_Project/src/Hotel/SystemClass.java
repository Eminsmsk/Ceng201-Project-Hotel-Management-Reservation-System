
package Hotel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class SystemClass {
    
    private static ArrayList<Guest> guests = new ArrayList<Guest>();
    private static ArrayList<Room> hotelRooms = new ArrayList<Room>();

    public SystemClass() {
        for (int i = 0; i < 32; i++) {
            hotelRooms.add(new BasicRoom(i+1));
        }
        for (int i = 32; i <48 ; i++) {
            hotelRooms.add(new SuitRoom(i+1));
        }
        for (int i = 48; i <52 ; i++) {
            hotelRooms.add(new KingRoom(i+1));
        }
        
    }
    public static ArrayList<Guest> findGuest(String name,String surname){
        ArrayList<Guest> temp = new ArrayList<Guest>();
        for (int i=0; i<guests.size();i++){
            if(guests.get(i).getName().equalsIgnoreCase(name)&&guests.get(i).getSurname().equalsIgnoreCase(surname))
                temp.add(guests.get(i));
            
       }
       if(temp.size()>0){
           return temp;
       }
       else{
           return null;
       }
        
    }
    
    
    
    public static Guest findGuest(String id){ //returning index of person in guests arraylist
        for (int i=0; i<guests.size();i++){
            if(guests.get(i).getIdNumber().equals(id))
                return guests.get(i);
            
       }
       return null;
    }
    
    private static ArrayList<Integer> bringGuestsInRoom(int roomNum){   //returning guests, in the given room, place in the guest arraylist. it used for remove method
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i=0; i<guests.size();i++){
            if(guests.get(i).getRoomNumber()==roomNum)
               temp.add(i); 
       }
       return temp;
    }
   
    public static ArrayList<Guest> guestsInRoom(int roomNum){
        ArrayList<Guest> temp = new ArrayList<>();
        for (int i=0; i<guests.size();i++){
            if(guests.get(i).getRoomNumber()==roomNum)
               temp.add(guests.get(i)); 
       }
       return temp;
    }
    
    
    
    
    public static boolean addGuest(Guest guest){
        if(findGuest(guest.getIdNumber())!=null){
            System.out.println("The guest "+guest.getName()+" "+guest.getSurname()+" with ID: "
                    +guest.getIdNumber()+" already exists");
            return false;
        }
        else{
            if(hotelRooms.get(guest.getRoomNumber()-1).getPresentCapacity()>=hotelRooms.get(guest.getRoomNumber()-1).getRoomCapacity()){
                System.out.println("The room is full.");
                
                return false;
            }
            else{
                    guests.add(guest);
                    
                    guest.setRoom(hotelRooms.get(guest.getRoomNumber()-1));
                    guest.getRoom().setPresentCapacity(guest.getRoom().getPresentCapacity()+1); 
                    return true;
                    
                    }
           
            
        } 
    }
    
    public static boolean removeRoom(int roomNum){
        for (int i = 0; i < hotelRooms.size(); i++) {
            if(roomNum - 1 == i){
                ArrayList<Integer> guestsInRoom = bringGuestsInRoom(roomNum);
                
                hotelRooms.get(i).setPresentCapacity(0);
                hotelRooms.get(i).setEntryDate(null);
                hotelRooms.get(i).setExitDate(null);
                hotelRooms.get(i).setTotalBill(0);
                int decrement=0;
                for (int j = 0; j < guestsInRoom.size(); j++) {
                    guests.remove(guestsInRoom.get(j)-decrement++);                    
                }  
                return true;
            }
        }
        
                return false;
     
    }
    
    public static void removeGuest(String id){
        
        bringRoom(findGuest(id).getRoomNumber()).setPresentCapacity(bringRoom(findGuest(id).getRoomNumber()).getPresentCapacity()-1);

       guests.remove(findGuest(id));        
   
    }
    
    
    
    
    public static String displayRoom(int roomNum){
        String temp = "";
        ArrayList<Guest> guestsInRoom = guestsInRoom(roomNum);
        for (int i = 0; i < guestsInRoom.size(); i++) {
             temp+= "\n"+guestsInRoom.get(i).getName()+" "+guestsInRoom.get(i).getSurname();
            
        }
           return temp;
 
        
    }
  

 
      public static int availableRoom(String roomType){
        if(roomType.equals("Basic Room")){
            for (int i = 0; i < 32; i++) {
                if(hotelRooms.get(i).getPresentCapacity()==0)
                    return i+1;
            }
        }
        else if(roomType.equals("Suit Room"))
             for (int i = 32; i < 48; i++) {
                if(hotelRooms.get(i).getPresentCapacity()==0)
                    return i+1;
            }
        else if(roomType.equals("King Room")){
             for (int i = 48; i < 52; i++) {
                if(hotelRooms.get(i).getPresentCapacity()==0)
                    return i+1;
            }
        }
        return -1;
        
    }
    public static Room bringRoom(int roomNo){
        return hotelRooms.get(roomNo-1);
    }
    
    public static double CalculateTotalBill(int roomNo,SportCenter sportCenter,Cinema cinema,DiningHall diningHall){
        double total = bringRoom(roomNo).calculateRoomBill();
       
        
        
        if(roomNo<49){
           for (int i = 0; i < guestsInRoom(roomNo).size(); i++) {
             if(guestsInRoom(roomNo).get(i).isCinema()){
                 total+=cinema.price()*bringRoom(roomNo).getReservedDays();
             }
             if(guestsInRoom(roomNo).get(i).isDiningHall()){
                 total+=diningHall.price()*bringRoom(roomNo).getReservedDays();
             }
             if(guestsInRoom(roomNo).get(i).isSportCenter()){
                 total+=sportCenter.price()*bringRoom(roomNo).getReservedDays();
             }
            
            } 
        }
        
        bringRoom(roomNo).setTotalBill(total);
        return total;
    }
    
    public static void writeToFile() throws FileNotFoundException, IOException{
        
        ObjectOutputStream outRoom = new ObjectOutputStream(new FileOutputStream("room.txt"));
        outRoom.writeObject(hotelRooms);
            
        outRoom.close();
        
        ObjectOutputStream outGuest = new ObjectOutputStream(new FileOutputStream("guest.txt"));
        outGuest.writeObject(guests);

        outGuest.close();
        
        
    }
    
     public static void readFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        ObjectInputStream inRoom = new ObjectInputStream(new FileInputStream("room.txt")); 
        hotelRooms = (ArrayList<Room>)inRoom.readObject();
        
        ObjectInputStream inGuest = new ObjectInputStream(new FileInputStream("guest.txt")); 
        guests = (ArrayList<Guest>)inGuest.readObject();

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static ArrayList<Guest> getGuests() {
        return guests;
    }

    public static ArrayList<Room> getHotelRooms() {
        return hotelRooms;
    }

        
    
    
   
    
}
