package med.voll.api.domain.record.doctor;

import med.voll.api.domain.entity.Doctor;

public record DoctorDataList(Long id, String name, String email, String crm, SpecialtyData specialtyData) {

        public DoctorDataList(Doctor doctor){
            this(doctor.getId(),doctor.getName(), doctor.getEmail(),doctor.getCrm(), doctor.getSpecialty());
        }

}
