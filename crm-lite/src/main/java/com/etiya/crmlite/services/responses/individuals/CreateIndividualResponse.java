package com.etiya.crmlite.services.responses.individuals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateIndividualResponse {
    private Long individualId;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private int genderId;
    private String motherName;
    private String fatherName;
    private Long nationalId;
}
