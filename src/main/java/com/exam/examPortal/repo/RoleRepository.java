package com.exam.examPortal.repo;

import com.exam.examPortal.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface RoleRepository extends JpaRepository<Role, Long> {
}
