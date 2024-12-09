package com.exam.examPortal.services;

import com.exam.examPortal.entity.User;
import com.exam.examPortal.entity.userRole;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    // create User

     public User createUser(User user, Set<userRole> userRoles) throws Exception;
     public List<User> getUSers();
     public Optional<User> getByID(Long Id);
     public User getByUserName(String userName);

     public void deleteByID(Long id);
}
