package main.model;
import java.util.ArrayList;

public class Doctor {
    private String id, name, specialty;
    private int maxSlots = 5;
    private ArrayList<String> bookedSlots = new ArrayList<>();
    
    public Doctor(String id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }
    
    public boolean isAvailable(String date) {
        return bookedSlots.size() < maxSlots && !bookedSlots.contains(date);
    }
    
    public void bookSlot(String date) {
        bookedSlots.add(date);
    }
    
    // getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
    public ArrayList<String> getBookedSlots() { return bookedSlots; }
    
    @Override
    public String toString() {
        return String.format("Doctor[ID:%s, %s (%s), Slots:%d/%d]", 
            id, name, specialty, bookedSlots.size(), maxSlots);
    }
}
