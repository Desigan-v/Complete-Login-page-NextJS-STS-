/*package com.example.mobi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.mobi.repository.UserRepository;
import com.example.mobi.security.PasswordEncoder;
import com.example.mobi.user.User;

@RestController
public class UserController {

    @Autowired
    UserRepository repo;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        Optional<User> user = repo.findByUsername(username);
        return user.orElse(null);
    }

    @PostMapping("/user/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        String salt = PasswordEncoder.generateSalt();
        String hashedPassword = PasswordEncoder.hashPassword(user.getHashedPassword(), salt);
        user.setSalt(salt);
        user.setHashedPassword(hashedPassword);
        repo.save(user);
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public User login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOpt = repo.findByUsername(loginRequest.getUsername());

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (PasswordEncoder.checkPassword(loginRequest.getPassword(), user.getHashedPassword())) {
                return user;
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
    }

    static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}




/*package com.example.mobi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.mobi.repository.UserRepository;
import com.example.mobi.security.PasswordEncoder;
import com.example.mobi.user.User;

@RestController
public class UserController {

    @Autowired
    UserRepository repo;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        Optional<User> user = repo.findByUsername(username);
        return user.orElse(null);
    }

    @PostMapping("/user/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        String salt = PasswordEncoder.generateSalt();
        String hashedPassword = PasswordEncoder.hashPassword(user.getHashedPassword(), salt);
        user.setSalt(salt);
        user.setHashedPassword(hashedPassword);
        repo.save(user);
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public User login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOpt = repo.findByUsername(loginRequest.getUsername());

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (PasswordEncoder.checkPassword(loginRequest.getPassword(), user.getHashedPassword())) {
                return user;
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
    }

    static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}

/*
package com.example.mobi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.mobi.repository.UserRepository;
import com.example.mobi.service.UserService;
import com.example.mobi.user.User;

@RestController
public class UserController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @GetMapping("/users/{username}")
    public User getUsers(@PathVariable String username) {
        Optional<User> users = repo.findByUsername(username);
        return users.orElse(null);
    }

    @PostMapping("/user/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUsers(@RequestBody User users) {
        userService.saveUser(users);
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public User login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = repo.findByUsername(loginRequest.getUsername());
        if (user.isPresent() && userService.checkPassword(user.get(), loginRequest.getPassword())) {
            return user.get();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }
    }

    static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
*/

/*
package com.example.mobi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobi.service.UserService;
import com.example.mobi.user.User;
@RestController
public class UserController {

    @Autowired
    	UserService userService;

    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/authendicateUsers")
    public String authendicateUser(@RequestBody User user)
    {
        return userService.authendicateUser(user);
    }

    static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
*/
/*
package com.example.mobi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.mobi.repository.UserRepository;
import com.example.mobi.security.PasswordEncoder;
import com.example.mobi.user.User;

@RestController
public class UserController {

    @Autowired
    UserRepository repo;
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repo.findAll();
    }


    @PostMapping("/user/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        if (user.getHashedPassword() == null || user.getUsername() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username and password must not be null");
        }

        String salt = PasswordEncoder.generateSalt();
        String hashedPassword = PasswordEncoder.hashPassword(user.getHashedPassword(), salt);
        user.setSalt(salt);
        user.setHashedPassword(hashedPassword);
        repo.save(user);
    }
    
    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public User login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOpt = repo.findByUsername(loginRequest.getUsername());

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (PasswordEncoder.checkPassword(loginRequest.getPassword(), user.getHashedPassword())) {
                return user;
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
    }

    static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}*/

package com.example.mobi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.mobi.repository.UserRepository;
import com.example.mobi.security.PasswordEncoder;
import com.example.mobi.user.User;

@RestController
public class UserController {

    @Autowired
    UserRepository repo;


    
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        Optional<User> user = repo.findByUsername(username);
        return user.orElse(null);
    }
    
    

    @PostMapping("/user/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        String salt = PasswordEncoder.generateSalt();
        String hashedPassword = PasswordEncoder.hashPassword(user.getHashedPassword(), salt);
        user.setSalt(salt);
        user.setHashedPassword(hashedPassword);
        repo.save(user);
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public User login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOpt = repo.findByUsername(loginRequest.getUsername());

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (PasswordEncoder.checkPassword(loginRequest.getPassword(), user.getHashedPassword())) {
                return user;
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
    }

    static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
