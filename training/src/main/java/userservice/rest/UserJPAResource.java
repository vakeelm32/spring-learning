package userservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import userservice.model.User;
import userservice.repository.UserRepository;
import userservice.services.UserDaoService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {

    @Autowired
    private UserDaoService service;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}
