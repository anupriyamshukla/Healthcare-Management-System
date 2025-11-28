package main;
import main.service.HealthcareService;
import main.util.FileManager;
import java.util.Scanner;

public class HealthcareMain {
    public static void main(String[] args) {
        FileManager.loadData();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\n=== E-HealthCare Management System ===");
            System.out.println("1. Patient Login    2. Admin Panel    3. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            
            if(choice == 1) patientMenu(sc);
            else if(choice == 2) adminMenu(sc);
            else { FileManager.saveData(); System.out.println("Goodbye!"); break; }
        }
        sc.close();
    }
    
    static void patientMenu(Scanner sc) {
        System.out.print("Enter Patient ID: ");
        String id = sc.next();
        if(HealthcareService.findPatient(id) != null) {
            System.out.println("1. Book Appointment  2. View Appointments  3. Back");
            int ch = sc.nextInt();
            if(ch == 1) HealthcareService.bookAppointmentMenu(sc, id);
            else if(ch == 2) HealthcareService.viewPatientAppointments(id);
        } else {
            System.out.println("Patient not found!");
        }
    }
    
    static void adminMenu(Scanner sc) {
        System.out.print("Admin Password: ");
        String pass = sc.next();
        if(pass.equals("admin123")) {
            while(true) {
                System.out.println("\n=== Admin Panel ===");
                System.out.println("1. Add Doctor       2. Remove Doctor");
                System.out.println("3. Add Patient      4. View All Patients");
                System.out.println("5. View All Doctors 6. View Reports");
                System.out.println("7. Back");
                System.out.print("Choice: ");
                
                int ch = sc.nextInt();
                sc.nextLine(); // consume newline
                
                if(ch == 1) {
                    HealthcareService.addDoctorMenu(sc);
                } else if(ch == 2) {
                    HealthcareService.removeDoctorMenu(sc);
                } else if(ch == 3) {
                    HealthcareService.addPatientMenu(sc);
                } else if(ch == 4) {
                    HealthcareService.viewAllPatients();
                } else if(ch == 5) {
                    HealthcareService.viewAllDoctors();
                } else if(ch == 6) {
                    HealthcareService.generateReport();
                } else if(ch == 7) {
                    break;
                } else {
                    System.out.println("Invalid choice!");
                }
            }
        } else {
            System.out.println("Invalid password!");
        }
    }


}
