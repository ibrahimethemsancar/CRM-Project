package com.etiya.crmlite.services.requests.addresses;

import com.etiya.crmlite.core.utilities.constants.Messages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubCreateAddressRequest {
    @NotNull(message = Messages.Validation.requiredField)
    @NotEmpty(message = Messages.Validation.requiredField)
    private String cityName;
    @NotNull(message = Messages.Validation.requiredField)
    @NotEmpty(message = Messages.Validation.requiredField)
    private String streetName;
    @NotNull(message = Messages.Validation.requiredField)
    @NotEmpty(message = Messages.Validation.requiredField)
    private String buildingName;
    @NotNull(message = Messages.Validation.requiredField)
    @NotEmpty(message = Messages.Validation.requiredField)
    private String addressDescription;
    @NotNull(message = Messages.Validation.requiredField)
    @NotEmpty(message = Messages.Validation.requiredField)
    private String countryName;
}
