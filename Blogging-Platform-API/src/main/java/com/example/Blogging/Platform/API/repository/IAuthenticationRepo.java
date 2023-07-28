package com.example.Blogging.Platform.API.repository;

import com.example.Blogging.Platform.API.model.AuthenticationToken;
import com.example.Blogging.Platform.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {


    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);
}
