package com.ninexlabs.lgdp.apigateway.api;

import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import com.ninexlabs.lgdp.commons.services.IBaseEndPointController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/api/v1/users/")
public class UserModuleEndpoint implements IBaseEndPointController<UserModelDetails> {

    private final RestTemplate restOps;

    @Value("${modules.user-module}")
    private String BASE_URL;

    @Autowired
    public UserModuleEndpoint(@Qualifier("restOps") RestTemplate restOps) {
        this.restOps = restOps;
    }

    @Override
    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity index() {
        String url = BASE_URL + "/api/v1/users/";

        return ResponseEntity.ok(this.restOps.getForEntity(url, Object.class).getBody());
    }

    @Override
    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity show(@PathVariable(name = "id") Long id) {
        String url = BASE_URL + "/api/v1/users/" + id;

        return ResponseEntity.ok(this.restOps.getForEntity(url, Object.class).getBody());
    }

    @Override
    public ResponseEntity create(UserModelDetails object) {
        String url = BASE_URL + "/api/v1/users/";

        return ResponseEntity.ok(this.restOps.postForObject(url, object, Object.class));
    }

    @Override
    public ResponseEntity edit(UserModelDetails object) {
        String url = BASE_URL + "/api/v1/users/" + object.getId();

        return ResponseEntity.ok(this.restOps.patchForObject(url, object, Object.class));
    }

    @Override
    public void delete(Long id) {

    }
}
