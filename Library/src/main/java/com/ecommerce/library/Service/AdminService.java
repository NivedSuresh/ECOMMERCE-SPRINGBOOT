package com.ecommerce.library.Service;

import com.ecommerce.library.Model.User.Admin;
import com.ecommerce.library.Dtos.AdminDto;

public interface AdminService {
    Admin save(AdminDto adminDto);
    Admin findByUsername(String username);

    boolean adminExists(String username);

    void changePassword(String password, String username);
}