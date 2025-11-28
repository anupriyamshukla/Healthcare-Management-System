package main.service;
import main.model.*;
import java.util.*;

public class HealthcareService {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static HashMap<String, Doctor> doctors = new HashMap<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    
    static {
        // Sample data
        patients.add(new Patient("P001", "Alice Smith", "9876543210", "Hypertension"));
        patients.add(new Patient("P002", "Bob Wilson", "9876543211", "Diabetes"));
        doctors.put("D001", new Doctor("D001", "Dr. Jane Doe", "Cardiology"));
        doctors.put("D002", new Doctor("D002", "Dr. John Lee", "General"));
    }
    
    public static void addPatient(Patient p) { patients.add(p); }
    public static Patient findPatient(String id) {
        return patients.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
    
    public static Doctor findDoctor(String id) {
        return doctors.get(id);
    }
    
    public static void bookAppointmentMenu(java.util.Scanner sc, String patientId) {
        System.out.println("\nAvailable Doctors:");
        doctors.values().forEach(System.out::println);
        
        System.out.print("Enter Doctor ID: ");
        String docId = sc.next();
        Doctor doc = findDoctor(docId);
        if(doc == null) {
            System.out.println("Doctor not found!");
            return;
        }
        
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.next();
        if(doc.isAvailable(date)) {
            String apptId = "A" + String.format("%03d", appointments.size() + 1);
            appointments.add(new Appointment(apptId, patientId, docId, date));
            doc.bookSlot(date);
            System.out.println("Appointment booked: " + apptId);
        } else {
            System.out.println("Doctor not available on this date!");
        }
    }
    
    public static void viewPatientAppointments(String patientId) {
        System.out.println("\nYour Appointments:");
        appointments.stream()
            .filter(a -> a.getPatientId().equals(patientId))
            .forEach(System.out::println);
    }
    
    public static void addDoctorMenu(java.util.Scanner sc) {
        System.out.print("Doctor ID: "); String id = sc.next();
        System.out.print("Name: "); sc.nextLine(); String name = sc.nextLine();
        System.out.print("Specialty: "); String spec = sc.nextLine();
        doctors.put(id, new Doctor(id, name, spec));
        System.out.println("Doctor added!");
    }
    
    public static void viewAllPatients() {
        System.out.println("\nAll Patients:");
        patients.forEach(System.out::println);
    }
    
    public static void generateReport() {
        System.out.println("\n=== Daily Report ===");
        System.out.println("Total Appointments: " + appointments.size());
        System.out.println("Busy Doctors:");
        doctors.values().stream()
            .filter(d -> !d.getBookedSlots().isEmpty())
            .forEach(System.out::println);
    }

    // public static void addPatientMenu(java.util.Scanner sc) {
    // System.out.print("Enter Patient ID: ");
    // String id = sc.next();
    // if(findPatient(id) != null) {
    //     System.out.println("Patient ID already exists!");
    //     return;
    // }
    // sc.nextLine(); // consume newline
    // System.out.print("Enter Name: ");
    // String name = sc.nextLine();
    // System.out.print("Enter Phone Number: ");
    // String phone = sc.nextLine();
    // System.out.print("Enter Medical History: ");
    // String history = sc.nextLine();
    
    // Patient p = new Patient(id, name, phone, history);
    // addPatient(p);
    // System.out.println("Patient added successfully!");
    // }

    // Add this method (for patient addition)
    public static void addPatientMenu(java.util.Scanner sc) {
        System.out.print("Enter Patient ID: ");
        String id = sc.next();
        if(findPatient(id) != null) {
            System.out.println("Patient ID already exists!");
            return;
        }
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Enter Medical History: ");
        String history = sc.nextLine();
        
        Patient p = new Patient(id, name, phone, history);
        patients.add(p);
        System.out.println("Patient added successfully! ID: " + id);
    }

    // Add this method (for viewing doctors)
    public static void viewAllDoctors() {
        System.out.println("\nAll Doctors:");
        if(doctors.isEmpty()) {
            System.out.println("No doctors registered.");
        } else {
            doctors.values().forEach(System.out::println);
        }
    }

    public static void removeDoctorMenu(java.util.Scanner sc) {
        System.out.print("Enter Doctor ID to remove: ");
        String id = sc.next();
        Doctor removed = doctors.remove(id);
        if(removed != null) {
            // Optionally, remove related appointments
            appointments.removeIf(a -> a.getDoctorId().equals(id));
            System.out.println("Doctor " + id + " removed successfully!");
        } else {
            System.out.println("Doctor ID not found!");
        }
    }


    
    // Getters for FileManager
    public static ArrayList<Patient> getPatients() { return patients; }
    public static HashMap<String, Doctor> getDoctors() { return doctors; }
    public static ArrayList<Appointment> getAppointments() { return appointments; }
}
