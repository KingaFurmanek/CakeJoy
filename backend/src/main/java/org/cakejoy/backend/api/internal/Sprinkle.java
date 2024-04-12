package org.cakejoy.backend.api.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Entity
@Table(name = "sprinkles")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Sprinkle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sprinkle_id")
    private Integer id;
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "sprinkles_order",
            joinColumns = { @JoinColumn(name = "sprinkle_id") },
            inverseJoinColumns = { @JoinColumn(name = "order_id") }
    )
    private Set<Orders> orders;
}
