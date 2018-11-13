package com.ninexlabs.lgdp.usermodule.controllers;

import com.ninexlabs.lgdp.commons.controllers.IBaseController;
import com.ninexlabs.lgdp.commons.models.RoleModelDetails;
import com.ninexlabs.lgdp.usermodule.services.RoleService;
import com.ninexlabs.lgdp.usermodule.services.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = VersionService.BASE_ROLE_PATH)
public class RoleController implements IBaseController<RoleModelDetails> {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity<Iterable<RoleModelDetails>> index() {
        return new ResponseEntity<>(this.roleService.index(), HttpStatus.OK);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<RoleModelDetails> show(@PathVariable Long id) {
        return new ResponseEntity<>(this.roleService.show(id), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<RoleModelDetails> store(@RequestBody @Valid RoleModelDetails details) {
        return new ResponseEntity<>(this.roleService.store(details), HttpStatus.OK);
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH, path = "{id}")
    public ResponseEntity<RoleModelDetails> edit(@RequestBody @Valid RoleModelDetails details) {
        return new ResponseEntity<>(this.roleService.update(details), HttpStatus.OK);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public void delete(Long id) {
        this.roleService.delete(id);
    }
}
