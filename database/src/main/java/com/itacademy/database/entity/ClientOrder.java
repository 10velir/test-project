package com.itacademy.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client_order", schema = "rental_company")
public class ClientOrder extends BaseEntity<Long> {

    @Column(name = "passport_details", nullable = false)
    private String passportDetails;

    @Column(name = "admin_approval")
    private Boolean adminApproval;

    @Column(name = "notes", nullable = false)
    private String notes;

    @Column(name = "lease_period", nullable = false)
    private LocalDateTime leasePeriod;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User user = new User();
}
