package med.voll.api.record;

public record Address(String streetAddress,
                      String neighborhood,
                      Integer zipCode,
                      String houseNumber,
                      String complement) {
}
