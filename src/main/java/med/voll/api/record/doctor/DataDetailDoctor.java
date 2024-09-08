package med.voll.api.record.doctor;

import med.voll.api.entity.Address;
import med.voll.api.entity.Doctor;

public record DataDetailDoctor(Long id, String name, String email, String phoneNumber, String crm, SpecialtyData specialtyData, Address address ) {

    public DataDetailDoctor(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhoneNumber(), doctor.getCrm(), doctor.getSpecialty(),doctor.getAddressData());
    }

}
