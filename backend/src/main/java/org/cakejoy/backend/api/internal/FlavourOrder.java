package org.cakejoy.backend.api.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name="flavour_order")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FlavourOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flavour_order_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "flavour_id")
    private Flavour flavour;

}
