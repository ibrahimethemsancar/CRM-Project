package com.etiya.crmlite.services.responses.addresses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAddressResponse {
    private Long partyId;
    private String cityName;
    private String streetName;
    private String buildingName;
    private String addressDescription;
    private String countryName;
}
