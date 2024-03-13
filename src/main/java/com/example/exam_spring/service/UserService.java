package com.example.exam_spring.service;


import com.example.exam_spring.entities.User;
import com.example.exam_spring.respositories.UserRespositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRespositoty userRepository;

    public List<User> getAll(){
        return  userRepository.findAll();
    }

    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return userRepository.findById(id).map(u->{
            u.setName(user.getName());
            u.setAge(user.getAge());
            u.setSalary(user.getSalary());
            return userRepository.save(u);
        }).orElseGet(()->{
            user.setId(id);
            return userRepository.save(user);
        });
    }

    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    public List<User> searchUser(String name){
        return userRepository.findAllByNameContaining(name);
    }

}
