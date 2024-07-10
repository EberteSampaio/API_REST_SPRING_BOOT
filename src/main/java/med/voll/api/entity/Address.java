package med.voll.api.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetAddress;
    private String neighborhood;
    private Integer zipCode;
    private String city;
    private String uf;
    private String houseNumber;
    private String complement;
}
