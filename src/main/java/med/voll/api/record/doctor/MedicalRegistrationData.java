package med.voll.api.record.doctor;


public record MedicalRegistrationData(String name,
                                      String email,
                                      Integer crm,
                                      Specialty specialty,
                                      Address address) {
}
