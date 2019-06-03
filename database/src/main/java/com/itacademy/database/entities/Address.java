package com.itacademy.database.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString(exclude = "users", callSuper = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "address", schema = "rental_company")
public class Address extends BaseEntity<Integer> {

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users = new HashSet<>();
}
