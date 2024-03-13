package com.ladera.telecom.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "call_details")
@AllArgsConstructor
@NoArgsConstructor
public class CallDetails extends BaseEntity {
    @Id
    @Column(name = "call_details_id")
    private String id;
    private String customerEmail;
    private Long supportTicketId;
    private String wavFileId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Long getSupportTicketId() {
        return supportTicketId;
    }

    public void setSupportTicketId(Long supportTicketId) {
        this.supportTicketId = supportTicketId;
    }

    public String getWavFileId() {
        return wavFileId;
    }

    public void setWavFileId(String wavFileId) {
        this.wavFileId = wavFileId;
    }
}
