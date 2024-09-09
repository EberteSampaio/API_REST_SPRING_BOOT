package med.voll.api.domain.record.others;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record AddressData(
        @NotBlank(message = "É necessário informar o nome da rua!")
        String streetAddress,

        @NotBlank(message = "É necessário informar o nome do bairro!")
        String neighborhood,

        @NotBlank(message = "O CEP deve ser informado!")
        @Pattern(regexp = "\\d{8}", message = "O CEP deve ter oito dígitos")
        String zipCode,

        @NotBlank(message = "A cidade deve ser informada!")
        String city,

        @NotBlank
        @Pattern(regexp = "[A-Z]{2}", message = "A UF deve conter dois dígitos!")
        String uf,

        @Positive(message = "Não existe números de casas negativos!")
        String houseNumber,

        String complement) {
}
