import java.util.Date;

// Subsystem Components
class PatientInfoSystem {
    void getPatientInfo(String patientId) {
        System.out.println("Retrieving patient info for ID: " + patientId);
    }
}

class AppointmentScheduler {
    void scheduleAppointment(String patientId, Date appointmentDate) {
        System.out.println("Scheduling appointment for patient ID: " + patientId + " on " + appointmentDate);
    }
}

class MedicalRecordSystem {
    void accessMedicalRecord(String patientId) {
        System.out.println("Accessing medical record for patient ID: " + patientId);
    }
}

// Facade Class
class HospitalManagementFacade {
    private PatientInfoSystem patientInfo = new PatientInfoSystem();
    private AppointmentScheduler scheduler = new AppointmentScheduler();
    private MedicalRecordSystem medicalRecords = new MedicalRecordSystem();

    public void getPatientDetails(String patientId) {
        patientInfo.getPatientInfo(patientId);
        scheduler.scheduleAppointment(patientId, new Date());
        medicalRecords.accessMedicalRecord(patientId);
    }
}

// Client Code
public class HospitalClient {
    public static void main(String[] args) {
        HospitalManagementFacade facade = new HospitalManagementFacade();
        facade.getPatientDetails("123456");
    }
}
