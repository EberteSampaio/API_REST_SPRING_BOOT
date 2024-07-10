package med.voll.api.record.doctor;

public record Address(String streetAddress,
                      String neighborhood,
                      Integer zipCode,
                      String city,
                      String uf,
                      String houseNumber,
                      String complement) {
}
