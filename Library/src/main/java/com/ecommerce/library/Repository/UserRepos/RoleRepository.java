package com.ecommerce.library.Repository.UserRepos;

import com.ecommerce.library.Model.User.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String name);

}
