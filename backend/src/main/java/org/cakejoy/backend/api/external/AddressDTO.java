package org.cakejoy.backend.api.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AddressDTO {
    private Integer id;
    private Integer userId;
    private String country;
    private String postcode;
    private String city;
    private String street;
    private String number;
}

