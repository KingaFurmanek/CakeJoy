package org.cakejoy.backend.api.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;
    private String occasion;
    private Double quantity;
    private Integer tiers;
    private String additionalInfo;
    private String colours;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String state;
    private Integer score;

    //Relacja OneToMany z klasą OrderUser
    @OneToMany(mappedBy = "order")
    private Set<OrderUser> orderUser;

    @ManyToMany(mappedBy = "orders")
    private Set<Flavour> flavours = new HashSet<>();

    @ManyToMany(mappedBy = "orders")
    private Set<AdditionalOptions> additionalOptions = new HashSet<>();

    @ManyToMany(mappedBy = "orders")
    private Set<Glaze> glazes = new HashSet<>();

    @ManyToMany(mappedBy = "orders")
    private Set<Sprinkle> sprinkles = new HashSet<>();

}
