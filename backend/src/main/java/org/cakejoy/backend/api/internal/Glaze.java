package org.cakejoy.backend.api.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Entity
@Table(name = "glaze")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Glaze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "glaze_id")
    private Integer id;
    private String name;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "glaze_order",
            joinColumns = { @JoinColumn(name = "glaze_id") },
            inverseJoinColumns = { @JoinColumn(name = "order_id") }
    )
    private Set<Orders> orders;
}
