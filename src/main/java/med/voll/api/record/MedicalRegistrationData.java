package med.voll.api.record;


public record MedicalRegistrationData(String name,
                                      String email,
                                      Integer crm,
                                      Specialty specialty,
                                      Address address) {
}
