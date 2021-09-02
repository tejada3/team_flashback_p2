package com.revature.flash_back_api.models.repos;

public interface CrudRepository<T> {


    T findById(String id);
    T save(T newResource);
    boolean update(T updateResource);
    boolean deleteById(String id);

}
