package com.project.david.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.david.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
