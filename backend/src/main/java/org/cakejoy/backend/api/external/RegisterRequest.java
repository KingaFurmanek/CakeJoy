package org.cakejoy.backend.api.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String country;
    private String postcode;
    private String city;
    private String street;
    private String number;
}
