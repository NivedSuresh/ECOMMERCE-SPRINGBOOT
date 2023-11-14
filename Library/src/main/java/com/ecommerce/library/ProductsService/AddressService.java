package com.ecommerce.library.ProductsService;

import com.ecommerce.library.Dtos.AddressDto;
import com.ecommerce.library.Model.User.Address;
import com.ecommerce.library.Model.User.Order;
import com.ecommerce.library.Model.User.OrderAddress;

import java.util.List;

public interface AddressService {

    void saveAddress(String email, AddressDto addressDto);

    List<AddressDto> findAll();

    List<Address> findAddressByCustomer(String name);

    AddressDto findAddressById(Long id);

    boolean existsById(Long id);

    OrderAddress addressDtoToOrderAddress(AddressDto address, Order order);

    AddressDto findDefaultAddressByCustomerEmail(String customerEmail);

    boolean addressBelongsToCustomer(Long id, String name);
}
