package com.etiya.crmlite.services.requests.contactMediums;

import com.etiya.crmlite.core.utilities.constants.Messages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateContactMediumRequest {
    @NotNull(message = Messages.Validation.requiredField)
    private Long partyId;
    @NotNull(message = Messages.Validation.requiredField)
    private String pstn;
    @NotNull(message = Messages.Validation.requiredField)
    private String fax;
    @NotNull(message = Messages.Validation.requiredField)
    @NotEmpty(message = Messages.Validation.requiredField)
    private String gsmNumber;
    @NotNull(message = Messages.Validation.requiredField)
    @NotEmpty(message = Messages.Validation.requiredField)
    private String email;
}
