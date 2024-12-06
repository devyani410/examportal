package com.exam.examPortal.services;

import com.exam.examPortal.entity.User;
import com.exam.examPortal.entity.userRole;
import java.util.Set;

public interface UserService {
    // create User

     public User createUser(User user, Set<userRole> userRoles) throws Exception;

}
