package med.voll.api.record.doctor;


import med.voll.api.record.others.AddressData;

public record MedicalRegistrationData(String name,
                                      String email,
                                      Integer crm,
                                      SpecialtyData specialty,
                                      AddressData address) {
}
