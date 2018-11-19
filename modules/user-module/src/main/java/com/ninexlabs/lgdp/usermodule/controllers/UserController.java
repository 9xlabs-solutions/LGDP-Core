package com.ninexlabs.lgdp.usermodule.controllers;

import com.ninexlabs.lgdp.commons.controllers.IBaseRestController;
import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import com.ninexlabs.lgdp.usermodule.services.UserService;
import com.ninexlabs.lgdp.usermodule.services.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = VersionService.BASE_USER_PATH)
public class UserController implements IBaseRestController<UserModelDetails> {

    private final UserService userService;

    @Autowired
    public UserController(UserService userRepository) {
        this.userService = userRepository;
    }

    /**
     * Show all users
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity<Iterable<UserModelDetails>> index() {
        return new ResponseEntity<>(this.userService.index(), HttpStatus.OK);
    }

    /**
     * Show a user
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<UserModelDetails> show(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.show(id), HttpStatus.OK);
    }

    /**
     * Store a new user in the database
     *
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<UserModelDetails> store(@RequestBody @Valid UserModelDetails request) {
        return new ResponseEntity<>(this.userService.store(request), HttpStatus.CREATED);
    }

    /**
     * Update the given user
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.PATCH, path = "{id}")
    public ResponseEntity<UserModelDetails> update(@PathVariable("id") UserModelDetails targetUser) {
        return new ResponseEntity<>(this.userService.update(targetUser), HttpStatus.OK);
    }

    /**
     * Delete a user when id is provided
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        this.userService.delete(id);
    }

}
