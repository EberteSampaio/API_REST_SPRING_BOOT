package med.voll.api.domain.record.patient;

import med.voll.api.domain.entity.Patient;

public record PatientDataList(Long id, String name, String email, String cpf) {

    public PatientDataList(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
