package med.voll.api.record.doctor;


import med.voll.api.record.others.Address;

public record MedicalRegistrationData(String name,
                                      String email,
                                      Integer crm,
                                      Specialty specialty,
                                      Address address) {
}
