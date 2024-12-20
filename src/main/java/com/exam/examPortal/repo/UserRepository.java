package com.exam.examPortal.repo;

import com.exam.examPortal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
public User findByuserName(String name);
public User findByuserNameAndPassword(String userName, String password);
}
