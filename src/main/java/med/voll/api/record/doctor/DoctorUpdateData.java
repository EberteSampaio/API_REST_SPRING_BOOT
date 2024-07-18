package med.voll.api.record.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.record.others.AddressData;

public record DoctorUpdateData(
        @NotNull
        Long id,

        String name,

        String phoneNumber,

        @Valid
        AddressData address) {
}
