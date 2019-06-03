package com.itacademy.database.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@ToString(of = {"series", "number"}, callSuper = true)
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@Builder
@Entity
@Table(name = "passport", schema = "rental_company")
public class Passport extends BaseEntity<Integer> {

    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;
}
