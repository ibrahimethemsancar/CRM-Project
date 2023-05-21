package com.etiya.crmlite.services.requests.individuals;

import com.etiya.crmlite.core.utilities.constants.Messages;
import com.etiya.crmlite.services.requests.addresses.SubCreateAddressRequest;
import com.etiya.crmlite.services.requests.contactMediums.SubCreateContactMediumRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualRequest {
    @NotNull(message = Messages.Validation.requiredField)
    @NotEmpty(message = Messages.Validation.requiredField)
    private String firstName;
    private String middleName;
    @NotNull(message = Messages.Validation.requiredField)
    @NotEmpty(message = Messages.Validation.requiredField)
    private String lastName;
    @NotNull(message = Messages.Validation.requiredField)
    @Past
    private LocalDate birthDate;
    @NotNull(message = Messages.Validation.requiredField)
    @Min(1)
    @Max(2)
    private int genderId;
    @NotNull(message = Messages.Validation.requiredField)
    private String motherName;
    @NotNull(message = Messages.Validation.requiredField)
    private String fatherName;
    @NotNull(message = Messages.Validation.requiredField)
    private Long nationalId;
    @Valid
    private SubCreateAddressRequest subCreateAddressRequest;
    @Valid
    private SubCreateContactMediumRequest subCreateContactMediumRequest;
}
