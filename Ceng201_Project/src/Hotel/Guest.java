/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;

import java.io.Serializable;

/**
 *
 * @author Emin
 */
public class Guest extends Person implements Serializable{
    private int roomNumber;
    private Room room;
    private boolean SportCenter;
    private boolean diningHall;
    private boolean cinema;

    public Guest(int roomNumber, String name, String surname, String nationality, String idNumber, int age) {
        super(name, surname, nationality, idNumber, age, "Guest");
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setSportCenter(boolean SportCenter) {
        this.SportCenter = SportCenter;
    }

    public void setDiningHall(boolean diningHall) {
        this.diningHall = diningHall;
    }

    public void setCinema(boolean cinema) {
        this.cinema = cinema;
    }

    public boolean isSportCenter() {
        return SportCenter;
    }

    public boolean isDiningHall() {
        return diningHall;
    }

    public boolean isCinema() {
        return cinema;
    }

    @Override
    public String toString() {
        return super.toString() + "Room Number: " + roomNumber + "\nRoom Type: " + room.getRoomType() + "\nSportCenter: " + SportCenter + "\nDiningHall: "
                + diningHall + "\nCinema: " + cinema + "\n\n";
    }
    
    
    
}
