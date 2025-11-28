package main.util;

import main.service.HealthcareService;
import java.io.*;
import java.util.*;

public class FileManager {
    private static final String PATIENTS_FILE = "data/patients.dat";
    private static final String DOCTORS_FILE = "data/doctors.dat";
    private static final String APPOINTMENTS_FILE = "data/appointments.dat";

    public static void saveData() {
        try {
            // Create data directory
            new File("data").mkdirs();

            // Save Patients
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATIENTS_FILE))) {
                oos.writeObject(HealthcareService.getPatients());
            }

            // Save Doctors
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DOCTORS_FILE))) {
                oos.writeObject(new ArrayList<>(HealthcareService.getDoctors().values()));
            }

            // Save Appointments
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(APPOINTMENTS_FILE))) {
                oos.writeObject(HealthcareService.getAppointments());
            }

            System.out.println("All data saved successfully!");
        } catch (Exception e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadData() {
        try {
            // Load Patients
            if (new File(PATIENTS_FILE).exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATIENTS_FILE))) {
                    HealthcareService.getPatients().clear();
                    HealthcareService.getPatients().addAll((ArrayList<main.model.Patient>) ois.readObject());
                }
            }

            // Load Doctors
            if (new File(DOCTORS_FILE).exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DOCTORS_FILE))) {
                    HealthcareService.getDoctors().clear();
                    ArrayList<main.model.Doctor> doctorList = (ArrayList<main.model.Doctor>) ois.readObject();
                    for (main.model.Doctor d : doctorList) {
                        HealthcareService.getDoctors().put(d.getId(), d);
                    }
                }
            }

            // Load Appointments
            if (new File(APPOINTMENTS_FILE).exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(APPOINTMENTS_FILE))) {
                    HealthcareService.getAppointments().clear();
                    HealthcareService.getAppointments().addAll((ArrayList<main.model.Appointment>) ois.readObject());
                }
            }
            System.out.println("✓ Data loaded successfully!");
        } catch (Exception e) {
            System.out.println("⚠️ Load failed, using sample data: " + e.getMessage());
        }
    }
}
