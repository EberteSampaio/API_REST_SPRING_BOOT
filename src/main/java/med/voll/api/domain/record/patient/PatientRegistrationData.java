package med.voll.api.domain.record.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.record.others.AddressData;

public record PatientRegistrationData(
        @NotBlank(message = "Por favor, preencha o nome completo!")
        String name,

        @NotBlank(message = "Por favor, preencha o e-mai!")
        @Email(message = "Por favor, o e-mail deve ser válido")
        String email,

        @NotBlank(message = "Por favor, preencha o seu número!")
        @Pattern(regexp = "\\d{11,13}",message="Por favor, o número de celular deve ter entre 11 e 13 dígitos")
        String phoneNumber,

        @NotBlank(message="Por favor, informe o CPF!")
        @Pattern(regexp = "\\d{11}", message="Por favor, o CPF deve ter 11 dígitos")
        String cpf,

        @Valid
        AddressData address
                                      ) {
}
