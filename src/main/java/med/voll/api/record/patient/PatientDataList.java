package med.voll.api.record.patient;

import med.voll.api.entity.Patient;

public record PatientDataList(Long id, String name, String email, String cpf) {

    public PatientDataList(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
