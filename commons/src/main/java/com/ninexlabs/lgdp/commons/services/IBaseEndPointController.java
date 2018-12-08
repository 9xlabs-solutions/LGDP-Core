package com.ninexlabs.lgdp.commons.services;

import org.springframework.http.ResponseEntity;

public interface IBaseEndPointController<T> {

    ResponseEntity index();

    ResponseEntity show(Long id);

    ResponseEntity create(T object);

    ResponseEntity edit(T object);

    void delete(Long id);

}
