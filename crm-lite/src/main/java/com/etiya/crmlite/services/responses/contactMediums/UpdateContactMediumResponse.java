package com.etiya.crmlite.services.responses.contactMediums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateContactMediumResponse {
    private Long partyId;
    private String pstn;
    private String fax;
    private String gsmNumber;
    private String email;
}
