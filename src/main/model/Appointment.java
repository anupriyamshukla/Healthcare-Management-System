package main.model;

public class Appointment {
    private String id, patientId, doctorId, date, status;
    
    public Appointment(String id, String patientId, String doctorId, String date) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.status = "booked";
    }
    
    // getters & setters
    public String getId() { return id; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    @Override
    public String toString() {
        return String.format("Appt[ID:%s, Patient:%s, Doctor:%s, Date:%s, %s]", 
            id, patientId, doctorId, date, status);
    }
}
