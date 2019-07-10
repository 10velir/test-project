package com.itacademy.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"users", "order"})
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "car", schema = "rental_company")
@OptimisticLocking(type = OptimisticLockType.VERSION)
@DynamicUpdate
public class Car extends BaseEntity<Long> {

    @Column(name = "supplier", nullable = false)
    private String supplier;

    @Column(name = "model", nullable = false)
    private String model;

    @Version
    private Long version;

    @Column(name = "max_speed")
    private Integer maxSpeed;

    @Column(name = "dollars_per_hour", nullable = false)
    private Integer price;

    @Builder.Default
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "car_user", schema = "rental_company",
                joinColumns = @JoinColumn(name = "car_id"),
                inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

/*    @ManyToOne(targetEntity = ClientOrder.class,fetch = FetchType.LAZY)
    @JoinTable(name = "client_order", schema = "rental_company",
                joinColumns = @JoinColumn(name = "car_id"),
                inverseJoinColumns = @JoinColumn(name = "id"))
    private ClientOrder order = new ClientOrder();*/
}