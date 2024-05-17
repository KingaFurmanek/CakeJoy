package org.cakejoy.backend.api.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.cakejoy.backend.api.internal.Address;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UsersDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String image;
    private AddressDTO address;
}
