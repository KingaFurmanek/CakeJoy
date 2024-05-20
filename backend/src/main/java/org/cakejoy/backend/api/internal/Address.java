package org.cakejoy.backend.api.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

@Data
@Entity
@Table(name="address")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private String country;
    private String postcode;
    private String city;
    private String street;
    private String number;

    @Override
    public int hashCode() {
        return Objects.hash(id, country, postcode, city, street, number);
    }
}
