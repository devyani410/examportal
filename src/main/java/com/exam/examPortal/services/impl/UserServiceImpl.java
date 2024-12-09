package com.exam.examPortal.services.impl;

import com.exam.examPortal.entity.User;
import com.exam.examPortal.entity.userRole;
import com.exam.examPortal.repo.RoleRepository;
import com.exam.examPortal.repo.UserRepository;
import com.exam.examPortal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<userRole> userRoles) throws Exception {
        User local = this.userRepository.findByuserName(user.getUserName());

        if(local!=null){
            System.out.println("User already exist");
            throw new Exception("User Already Present");
        }else{

            // create User
            for(userRole userRole1:userRoles ){
                roleRepository.save(userRole1.getRole());
            }

            user.setUserRoles(userRoles);
           local= this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public List<User> getUSers(){
      return  this.userRepository.findAll();
    }

    @Override
    public Optional<User> getByID(Long Id) {
        return this.userRepository.findById(Id);
    }

    @Override
    public User getByUserName(String userName) {
        return this.userRepository.findByuserName(userName);
    }

    @Override
    public void deleteByID(Long id) {
         this.userRepository.deleteById(id);
    }


}
