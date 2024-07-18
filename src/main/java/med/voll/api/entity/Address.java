package med.voll.api.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.record.others.AddressData;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String streetAddress;
    private String neighborhood;
    private String zipCode;
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


    public void updateData(AddressData address) {

        if(address.streetAddress() != null){
            this.setStreetAddress(address.streetAddress());
        }

        if(address.neighborhood() != null){
            this.setNeighborhood(address.neighborhood());
        }

        if(address.zipCode() != null){
            this.setZipCode(address.zipCode());
        }

        if(address.city() != null){
            this.setCity(address.city());
        }

        if(address.uf() != null){
            this.setUf(address.uf());
        }

        if(address.houseNumber() != null){
            this.setHouseNumber(address.houseNumber());
        }

        if(address.complement() != null){
            this.setComplement(address.complement());
        }

    }
}
