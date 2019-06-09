package com.itacademy.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = "users")
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "car", schema = "rental_company")
public class Car extends BaseEntity<Long> {

    @Column(name = "supplier", nullable = false)
    private String supplier;

    @Column(name = "model", nullable = false)
    private String model;

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
}