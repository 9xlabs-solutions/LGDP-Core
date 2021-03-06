package com.ninexlabs.lgdp.usermodule.services;

import com.ninexlabs.lgdp.commons.LGDPException;
import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import com.ninexlabs.lgdp.commons.services.IBaseService;
import com.ninexlabs.lgdp.usermodule.models.User;
import com.ninexlabs.lgdp.usermodule.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class UserService implements IBaseService<UserModelDetails> {

    // user repository
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Iterable<UserModelDetails> index() {

        Iterable<User> users = this.userRepository.findAll();

        ArrayList<UserModelDetails> formattedUserDetails = new ArrayList<>();

        for (User user : users) {
            formattedUserDetails.add(user.getUserModelDetails());
        }

        return formattedUserDetails;
    }

    @Override
    public UserModelDetails show(Long id) {

        Optional<User> user = this.userRepository.findById(id);

        if (user.isPresent()) {
            return user.get().getUserModelDetails();
        }

        throw new LGDPException(LGDPException.ExceptionType.ACCOUNT_NOT_EXISTS, "Account does not exists");

    }

    @Override
    public synchronized UserModelDetails store(UserModelDetails details) {

        Optional<User> user = this.userRepository.findById(details.getId());

        if (!user.isPresent()) {

            User new_user = new User();

            BeanUtils.copyProperties(details, new_user);

            new_user.setPassword(passwordEncoder.encode(details.getPassword()));

            return this.saveUser(new_user);

        }

        throw new LGDPException(LGDPException.ExceptionType.ALREADY_EXIST_EXCEPTION, "Account does not exists");
    }

    @Override
    public synchronized UserModelDetails update(UserModelDetails details) {

        Optional<User> user = this.userRepository.findById(details.getId());

        if (user.isPresent()) {
            return this.saveUser(user.get());
        }

        throw new LGDPException(LGDPException.ExceptionType.ACCOUNT_NOT_EXISTS, "Account does not exists");
    }

    @Override
    public void delete(Long id) {

        Optional<User> userOptional = this.userRepository.findById(id);

        if (userOptional.isPresent()) {
            this.userRepository.delete(userOptional.get());
        } else {
            throw new LGDPException(LGDPException.ExceptionType.ACCOUNT_NOT_EXISTS, "Account does not exists");
        }
    }

    /**
     * Get the user by provided ID.
     *
     * @param username
     * @return
     */
    public UserModelDetails findUserByUsername(String username) {

        Optional<User> user = this.userRepository.findUserByUsername(username);

        if (user.isPresent()) {

            if (user.get().getIsActive()) {
                return user.get().getUserModelDetails();
            }

            throw new LGDPException(LGDPException.ExceptionType.ACCOUNT_NOT_VERIFIED, "Account does not exists or not activated");

        }

        throw new LGDPException(LGDPException.ExceptionType.ACCOUNT_NOT_EXISTS, "Account does not exists");
    }

    /**
     * Save user details in the database
     *
     * @param user User Object
     * @return UserModelDetails
     */
    private UserModelDetails saveUser(User user) {

        user = this.userRepository.save(user);

        return user.getUserModelDetails();
    }

}
