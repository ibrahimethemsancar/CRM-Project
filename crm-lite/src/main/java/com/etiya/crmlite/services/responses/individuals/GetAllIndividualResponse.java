package com.etiya.crmlite.services.responses.individuals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllIndividualResponse {
    private Long partyId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String role;
    private Long nationalId;
}
