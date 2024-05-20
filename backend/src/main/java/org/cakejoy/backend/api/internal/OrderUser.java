package org.cakejoy.backend.api.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

@Data
@Entity
@Table(name = "order_users")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_user_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderUser orderUser = (OrderUser) o;
        return Objects.equals(id, orderUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
