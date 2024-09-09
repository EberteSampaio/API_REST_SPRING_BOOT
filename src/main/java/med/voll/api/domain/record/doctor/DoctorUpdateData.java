package med.voll.api.domain.record.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.record.others.AddressData;

public record DoctorUpdateData(
        @NotNull
        Long id,

        String name,

        String phoneNumber,

        @Valid
        AddressData address) {
}
