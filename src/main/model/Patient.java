package main.model;

public class Patient {
    private String id, name, phone, medicalHistory;
    
    public Patient(String id, String name, String phone, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.medicalHistory = medicalHistory;
    }
    
    // getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getMedicalHistory() { return medicalHistory; }
    
    @Override
    public String toString() {
        return String.format("Patient[ID:%s, Name:%s, Phone:%s]", id, name, phone);
    }
}
