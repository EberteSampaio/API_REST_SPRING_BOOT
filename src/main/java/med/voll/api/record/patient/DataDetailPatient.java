package med.voll.api.record.patient;

import med.voll.api.entity.Address;
import med.voll.api.entity.Patient;

public record DataDetailPatient(Long id, String name, String email, String phoneNumber, String cpf, Address addressData) {

    public DataDetailPatient(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhoneNumber(), patient.getCpf(), patient.getAddressData());
    }

}
