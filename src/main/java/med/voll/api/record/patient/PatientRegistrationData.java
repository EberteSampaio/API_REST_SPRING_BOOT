package med.voll.api.record.patient;

import med.voll.api.record.others.Address;

public record PatientRegistrationData(String name,
                                      String email,
                                      String phoneNumber,
                                      String cpf,
                                      Address address
                                      ) {
}
