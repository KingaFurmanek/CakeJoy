package org.cakejoy.backend.api.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Entity
@Table(name = "decorations")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Decoration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "decoration_id")
    private Integer id;
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "decorations_order",
            joinColumns = { @JoinColumn(name = "decoration_id") },
            inverseJoinColumns = { @JoinColumn(name = "order_id") }
    )
    private Set<Orders> orders;
}
