package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, String >{

    public boolean findByEmail(String email);

}
