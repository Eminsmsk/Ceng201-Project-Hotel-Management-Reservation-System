
package Hotel;

import java.io.Serializable;
import java.util.Date;


public abstract class Room implements Serializable{
    private String roomType;
    private int reservedDays;
    private double roomPrice;
    private int roomNumber; // oda numarası
    private int roomCapacity;  // oda kapasitesi kişi sayısı olarak
    private int roomArea; // odanın metrekaresi
    private String roomDecoration;  // oda dekorasyonu (ultra lüks - lüks - normal) 
    private int lcdTV;
    private boolean wifi; 
    private int presentCapacity=0;
    private double totalBill;
    private Date entryDate;
    private Date exitDate;
    
    
  

    public Room(String roomType, int roomNumber, int roomCapacity,String roomDecoration, int lcdTV) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.roomDecoration = roomDecoration;
        this.lcdTV = lcdTV;
        this.wifi = true;
    }


    abstract int calculateRoomArea();
    
    abstract double calculateRoomBill();
        
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public int getReservedDays() {
        return reservedDays;
    }

    public void setReservedDays(int reservedDays) {
        this.reservedDays = reservedDays;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }



    public String getRoomDecoration() {
        return roomDecoration;
    }

    public int getLcdTV() {
        return lcdTV;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public double getTotalBill() {
        return totalBill;
    }
    
    
    
    
    

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomArea(int roomArea) {
        this.roomArea = roomArea;
    }

    public void setRoomDecoration(String roomDecoration) {
        this.roomDecoration = roomDecoration;
    }

    public int getPresentCapacity() {
        return presentCapacity;
    }

    public void setPresentCapacity(int presentCapacity) {
        this.presentCapacity = presentCapacity;
    }

    
    
    
    @Override
    public String toString() {
        return  "Room Number: " + roomNumber + "\nRoom Capacity: " + roomCapacity + "\nPresent Capacity: "+presentCapacity
                +"\nEntry Date: " + (entryDate != null ?  entryDate.getDate():"--") +"."+(entryDate != null ? entryDate.getMonth()+1:"--")+"."+(entryDate != null ? entryDate.getYear()+1900:"--")
                +"\nExit Date: " +  (exitDate != null ?  exitDate.getDate():"--") +"."+(exitDate != null ? exitDate.getMonth()+1:"--")+"."+(exitDate != null ? exitDate.getYear()+1900:"--")
                +"\nTotal Bill: " + totalBill
                +"\nRoom Area(m^2): " + roomArea + "\nRoom Decoration: " + roomDecoration 
                +"\nWifi: "+ wifi + "\nLcd TV: " + lcdTV + "\n";
    }
    
    
    
    
    
    
    
  
}
