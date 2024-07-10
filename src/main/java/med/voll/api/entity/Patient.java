package med.voll.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import med.voll.api.record.others.AddressData;


public class Patient {
    private Long id;
    private String name;
    private String phoneNumber;
    private String cpf;
    private AddressData addressData;
}
