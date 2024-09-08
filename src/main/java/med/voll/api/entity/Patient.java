package med.voll.api.entity;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.record.patient.PatientRegistrationData;
import med.voll.api.record.patient.PatientUpdateData;

@Table(name = "pacientes")
@Entity(name = "Patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String cpf;
    @Embedded
    private Address addressData;
    private Boolean status;

    public Patient(PatientRegistrationData patientData){
        this.setName(patientData.name());
        this.setEmail(patientData.email());
        this.setPhoneNumber(patientData.phoneNumber());
        this.setCpf(patientData.cpf());
        this.addressData = new Address(patientData.address());
        this.setStatus(true);
    }

    public void updateData(PatientUpdateData patient) {
        if(patient.name() != null){
            this.setName(patient.name());
        }

        if(patient.phoneNumber() != null){
            this.setPhoneNumber(patient.phoneNumber());
        }

        if(patient.data() != null){
            this.getAddressData().updateData(patient.data());
        }
    }
}
