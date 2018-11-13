package com.ninexlabs.lgdp.commons.services;

public interface IBaseService<T> {

    /**
     * Get all records
     *
     * @return list of objects
     */
    Iterable<T> index();

    /**
     * Get a specific resource by id
     *
     * @param id
     * @return single item
     */
    T show(Long id);

    /**
     * Store a new resource in the database
     *
     * @param user
     * @return created item
     */
    T store(T user);

    /**
     * Update a specific record in the database
     *
     * @param user
     * @return updated item
     */
    T update(T user);

    /**
     * Delete the specific resource by id
     *
     * @param id
     */
    void delete(Long id);

}
