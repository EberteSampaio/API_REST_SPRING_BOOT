package med.voll.api.record.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.record.others.AddressData;

public record PatientUpdateData(
        @NotNull
        Long id,

        String name,

        String phoneNumber,

        @Valid
        AddressData data
) {
}
