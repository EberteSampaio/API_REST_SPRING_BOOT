package med.voll.api.record.doctor;

import med.voll.api.entity.Doctor;

public record MedicalDataList(String name, String email, String crm, SpecialtyData specialtyData) {

        public MedicalDataList(Doctor doctor){
            this(doctor.getName(), doctor.getEmail(),doctor.getCrm(), doctor.getSpecialty());
        }

}
