package med.voll.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.record.doctor.MedicalRegistrationData;
import med.voll.api.record.doctor.SpecialtyData;

@Table(name = "medicos")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private SpecialtyData specialty;

    @Embedded
    private Address addressData;


    public Doctor(MedicalRegistrationData doctor) {
        this.name        = doctor.name();
        this.email       = doctor.email();
        this.crm         = doctor.crm();
        this.specialty   = doctor.specialty();
        this.addressData = new Address(doctor.address());
    }
}
