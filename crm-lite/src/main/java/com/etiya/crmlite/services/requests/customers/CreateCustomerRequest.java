package com.etiya.crmlite.services.requests.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
    private Long partyRoleId;
    private Long statusId;
    private Long customerTypeId;
}
