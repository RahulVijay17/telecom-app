package com.ladera.telecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallDetailsDto  {
    private String id;
    private String customerEmail;
    private Long supportTicketId;
    private String wavFileId;

}
