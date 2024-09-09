package med.voll.api.domain.record.patient;

import med.voll.api.domain.entity.Address;
import med.voll.api.domain.entity.Patient;

public record DataDetailPatient(Long id, String name, String email, String phoneNumber, String cpf, Address addressData) {

    public DataDetailPatient(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhoneNumber(), patient.getCpf(), patient.getAddressData());
    }

}
