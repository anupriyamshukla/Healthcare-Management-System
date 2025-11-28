# 5.2 Statement.md - E-HealthCare Management System

## Problem Statement
Traditional healthcare facilities rely on manual record-keeping and paper-based appointment systems, leading to inefficiencies such as:
- **Lost patient records** and incomplete medical histories
- **Overbooked doctor schedules** due to lack of availability tracking
- **Long patient wait times** from poor appointment coordination
- **Administrative errors** in patient/doctor data management
- **No centralized reporting** for hospital operations and resource utilization

These issues result in compromised patient care, increased operational costs, and frustrated healthcare staff.

## Scope of the Project
This project develops a **console-based Java application** to streamline core healthcare operations including:
- Patient registration and medical history tracking
- Doctor profile management with appointment slot limits (max 5 per date)
- Appointment booking with real-time availability validation
- Admin dashboard for CRUD operations and reporting
- Persistent data storage using file serialization

**Out of Scope**: Database integration, GUI interface, real-time notifications, payment processing.

## Target Users
1. **Hospital Administrators** - Manage doctors, patients, and generate operational reports
2. **Front Desk Staff** - Register patients and book appointments
3. **Patients** - View personal appointments and medical history (via ID login)
4. **Course Instructors/Evaluators** - Demonstrate OOP, collections, file I/O concepts

## High-Level Features

### Patient Management
- Register new patients with medical history
- View patient details by ID
- Persistent storage across sessions

### Doctor Management
- Add/remove doctors with specialties
- Track availability (5 slots max per date)
- View all doctors and their bookings

### Appointment System
- Book appointments with availability check
- View patient-specific appointments
- Automatic slot allocation

### Admin Panel (Password: admin123)
- Full CRUD operations
- Generate daily reports
- Data backup/restore

### Data Persistence
- Automatic save on exit
- Load on startup
- File-based serialization (.dat files)


**Technical Implementation**: Pure Java OOP with ArrayList/HashMap collections, ObjectInputStream/ObjectOutputStream for persistence, console UI with menu-driven navigation.
