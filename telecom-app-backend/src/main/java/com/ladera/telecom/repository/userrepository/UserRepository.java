package com.ladera.telecom.repository.userrepository;

import com.ladera.telecom.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByEmail(String email);
    boolean existsByMobileNumber(String mobileNumber);
}
