package com.etiya.crmlite.services.responses.addresses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubCreateAddressResponse {
    private String cityName;
    private String streetName;
    private String buildingName;
    private String addressDescription;
    private String countryName;
}
