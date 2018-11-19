package com.ninexlabs.lgdp.commons.controllers;

import org.springframework.http.ResponseEntity;

public interface IBaseRestController<T> {

    // Todo : extend this from separate classes service classes.

    /**
     * List all resources.
     *
     * @return list of objects
     */
    ResponseEntity<Iterable<T>> index();

    /**
     * Show a specific resource
     *
     * @param id primary key of the resource
     * @return single instance of a resource
     */
    ResponseEntity<T> show(Long id);

    /**
     * Store a resource in the database
     *
     * @param object object to store
     * @return Object to that got stored
     */
    ResponseEntity<T> store(T object);

    /**
     * Update a resource in the database
     *
     * @param object object to update
     * @return Object to update
     */
    ResponseEntity<T> update(T object);

    /**
     * Delete an resource from database.
     *
     * @param id id of the object
     * @return
     */
    void delete(Long id);
}
