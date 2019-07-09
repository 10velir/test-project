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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true, exclude = "car")
@EqualsAndHashCode(exclude = {"car"}, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client_order", schema = "rental_company")
public class ClientOrder extends BaseEntity<Long> {

    @Column(name = "passport_details")
    private String passportDetails;

    @Column(name = "admin_approval")
    private Boolean adminApproval;

    @Column(name = "notes")
    private String notes;

    @Column(name = "lease_period_from", nullable = false)
    private LocalDateTime leaseDateAndTimeFrom;

    @Column(name = "lease_period_to", nullable = false)
    private LocalDateTime leaseDateAndTimeTo;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User user = new User();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> car = new ArrayList<>();
}
