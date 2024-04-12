package org.cakejoy.backend.api.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Entity
@Table(name = "additional_options")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AdditionalOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "additional_option_id")
    private Integer id;
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "additional_options_order",
            joinColumns = { @JoinColumn(name = "additional_option_id") },
            inverseJoinColumns = { @JoinColumn(name = "order_id") }
    )
    private Set<Orders> orders;
}
