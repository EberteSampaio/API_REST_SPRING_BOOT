package med.voll.api.record.doctor;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.record.others.AddressData;

public record DoctorRegistrationData(

        @NotBlank(message = "Por favor, preencha o nome!")
        String name,

        @NotBlank(message = "Por favor, preencha o e-mail!")
        @Email(message = "É necessário um e-mail válido!")
        String email,

        @NotBlank(message = "Por favor, preencha o número de telefone!")
        @Pattern(regexp = "\\d{11,13}",message = "O número de telefone deve ter 13 dígitos!")
        String phoneNumber,

        @NotBlank(message = "Por favor, preencha o crm!")
        @Pattern(regexp = "\\d{4,6}",message = "O crm deve ter entre 4 a 6 dígitos!")
        String crm,

        @NotNull(message = "Por favor, informe a especialidade!")
        SpecialtyData specialty,

        @NotNull(message = "Por favor, informe o seu endereço!")
        @Valid
        AddressData address) {
}
