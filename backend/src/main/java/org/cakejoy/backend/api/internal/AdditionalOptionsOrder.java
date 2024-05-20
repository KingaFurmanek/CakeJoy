package org.cakejoy.backend.api.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "additional_options_order")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AdditionalOptionsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "additional_option_order_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "additional_option_id")
    private AdditionalOptions additionalOptions;
}
