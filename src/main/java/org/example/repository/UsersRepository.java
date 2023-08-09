package org.example.repository;

import org.example.models.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    UsersEntity getById(int id);
    UsersEntity findByUsername(String username);
}