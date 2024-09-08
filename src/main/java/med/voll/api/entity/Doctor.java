package med.voll.api.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import med.voll.api.record.doctor.DoctorRegistrationData;
import med.voll.api.record.doctor.DoctorUpdateData;
import med.voll.api.record.doctor.SpecialtyData;

@Table(name = "medicos")
@Entity(name = "Doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String crm;

    @Enumerated(EnumType.STRING)
    private SpecialtyData specialty;

    @Embedded
    private Address addressData;

    private Boolean status;


    public Doctor(DoctorRegistrationData doctor) {
        this.name        = doctor.name();
        this.email       = doctor.email();
        this.phoneNumber = doctor.phoneNumber();
        this.crm         = doctor.crm();
        this.specialty   = doctor.specialty();
        this.addressData = new Address(doctor.address());
        this.setStatus(true);
    }

    public void updateData(@Valid DoctorUpdateData doctor) {
        if(doctor.name() != null){
            this.setName(doctor.name());
        }

        if(doctor.phoneNumber() != null){
            this.setPhoneNumber(doctor.phoneNumber());
        }

        if(doctor.address() != null){
            this.getAddressData().updateData(doctor.address());
        }

    }
}
