package med.voll.api.record.others;

public record AddressData(String streetAddress,
                          String neighborhood,
                          Integer zipCode,
                          String city,
                          String uf,
                          String houseNumber,
                          String complement) {
}
