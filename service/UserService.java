/*package com.example.mobi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mobi.repository.UserRepository;
import com.example.mobi.user.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User saveUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getHashedPassword());
        user.setHashedPassword(encodedPassword);
        return userRepository.save(user);
    }

    public boolean checkPassword(User user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getHashedPassword());
    }
}

/*
package com.example.mobi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mobi.exceptions.UserNotFoundException;
import com.example.mobi.repository.UserRepository;
import com.example.mobi.user.User;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public String authendicateUser (User user) throws UserNotFoundException
    {
    	Optional<User> opOser = userRepository.findById(user.getUsername());
    	if(opUser.isPresent())
    	{
    		User dbUser=opUser.get();
    		if(user.getPassword().equals(dbUser.getPassword()))
    			return "Authenticated User";
    		else
    			return "Incorrect password";
    	}
    	throw new UserNotFoundException("No user is not found for this username !!!");
    }
    public String addUser(User user)
    {
    	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    	String encryptedpwd = bcrypt.encode(user.getPassword());
    	user.setPassword(encryptedpwd);
    	User saveUser = userRepository.save(user);
    	return saveUser.getUsername()+"added to database successfully";
    }
    
}
*/
/*
package com.example.mobi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mobi.repository.UserRepository;
import com.example.mobi.user.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User saveUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getHashedPassword());
        user.setHashedPassword(encodedPassword);
        return userRepository.save(user);
    }

    public boolean checkPassword(User user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getHashedPassword());
    }
}
*/

package com.example.mobi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mobi.repository.UserRepository;
import com.example.mobi.user.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User saveUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getHashedPassword());
        user.setHashedPassword(encodedPassword);
        return userRepository.save(user);
    }

    public boolean checkPassword(User user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getHashedPassword());
    }
}
