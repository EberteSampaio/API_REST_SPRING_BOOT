package med.voll.api.record.patient;

import med.voll.api.record.others.AddressData;

public record PatientRegistrationData(String name,
                                      String email,
                                      String phoneNumber,
                                      String cpf,
                                      AddressData addressData
                                      ) {
}
