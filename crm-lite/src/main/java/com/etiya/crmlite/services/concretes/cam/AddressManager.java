package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.constants.Messages;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.generalCodes.StatusCodes;
import com.etiya.crmlite.core.utilities.generalCodes.TypeCodes;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.core.utilities.results.SuccessResult;
import com.etiya.crmlite.entities.concretes.cam.Addr;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.repositories.cam.IAddressRepository;
import com.etiya.crmlite.services.abstracts.cam.IAddressService;
import com.etiya.crmlite.services.requests.addresses.DeleteAddressRequest;
import com.etiya.crmlite.services.requests.addresses.SubCreateAddressRequest;
import com.etiya.crmlite.services.requests.addresses.UpdateAddressRequest;
import com.etiya.crmlite.services.responses.addresses.SubCreateAddressResponse;
import com.etiya.crmlite.services.responses.addresses.UpdateAddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AddressManager implements IAddressService {
    private IAddressRepository addressRepository;
    private IMessageSourceService messageSourceService;

    @Autowired
    public AddressManager(IAddressRepository addressRepository, IMessageSourceService messageSourceService) {
        this.addressRepository = addressRepository;
        this.messageSourceService = messageSourceService;
    }

    @Transactional
    @Override
    public DataResult<SubCreateAddressResponse> addAddressForCustomer(SubCreateAddressRequest subCreateAddressRequest, Party party) {
        Addr address = addressBuilder(subCreateAddressRequest, party);
        SubCreateAddressResponse response = subCreateAddressResponseBuilder(address);
        addressRepository.save(address);

        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Address.addressAdded));
    }

    @Override
    public DataResult<UpdateAddressResponse> updateAddress(UpdateAddressRequest updateAddressRequest) {
        Addr address = getAddress(updateAddressRequest.getAddressId());
        address.setCityName(updateAddressRequest.getCityName());
        address.setStrtName(updateAddressRequest.getStreetName());
        address.setBldgName(updateAddressRequest.getBuildingName());
        address.setAddrDesc(updateAddressRequest.getAddressDescription());
        address.setCntryName(updateAddressRequest.getCountryName());

        Addr updatedAddress = addressRepository.save(address);

        UpdateAddressResponse response = updateAddressResponseBuilder(updatedAddress);

        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Address.addressUpdated));
    }

    @Transactional
    @Override
    public Result deleteAddress(DeleteAddressRequest deleteAddressRequest) {
        Addr deletedAddress = getAddress(deleteAddressRequest.getAddressId());
        deletedAddress.setIsActv(StatusCodes.PASS);
        addressRepository.save(deletedAddress);
        return new SuccessResult(messageSourceService.getMessage(Messages.Address.addressDeleted));
    }

    private UpdateAddressResponse updateAddressResponseBuilder(Addr updatedAddress) {
        return UpdateAddressResponse.builder()
                .addressId(updatedAddress.getAddrId())
                .cityName(updatedAddress.getCityName())
                .streetName(updatedAddress.getStrtName())
                .buildingName(updatedAddress.getBldgName())
                .addressDescription(updatedAddress.getAddrDesc())
                .countryName(updatedAddress.getCntryName())
                .build();
    }

    private Addr getAddress(Long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new BusinessException(messageSourceService.getMessage(Messages.Address.addressNotFound)));
    }

    private SubCreateAddressResponse subCreateAddressResponseBuilder(Addr address) {
        SubCreateAddressResponse response = SubCreateAddressResponse.builder()
                .cityName(address.getCityName())
                .streetName(address.getStrtName())
                .buildingName(address.getBldgName())
                .addressDescription(address.getAddrDesc())
                .countryName(address.getCntryName())
                .build();

        return response;
    }

    private Addr addressBuilder(SubCreateAddressRequest subCreateAddressRequest, Party party) {
        Addr address = Addr.builder()
                .cityName(subCreateAddressRequest.getCityName())
                .strtName(subCreateAddressRequest.getStreetName())
                .bldgName(subCreateAddressRequest.getBuildingName())
                .addrDesc(subCreateAddressRequest.getAddressDescription())
                .cntryName(subCreateAddressRequest.getCountryName())
                .dataTpId(TypeCodes.ETIYA_TYPE_VALUE_PARTY)
                .rowId(party.getPartyId())
                .isActv(StatusCodes.ACTV)
                .build();
        return address;
    }
}

