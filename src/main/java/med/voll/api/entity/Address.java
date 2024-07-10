package med.voll.api.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.record.others.AddressData;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String streetAddress;
    private String neighborhood;
    private Integer zipCode;
    private String city;
    private String uf;
    private String houseNumber;
    private String complement;

    public Address(AddressData addressData) {
        this.streetAddress  = addressData.streetAddress();
        this.neighborhood   = addressData.neighborhood();
        this.zipCode        = addressData.zipCode();
        this.city           = addressData.city();
        this.uf             = addressData.uf();
        this.houseNumber    = addressData.houseNumber();
        this.complement     = addressData.complement();

    }


}
