package org.example.repo;

import org.apache.catalina.User;
import org.example.models.Model;
import org.example.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {

//    @Query("SELECT p.festival FROM Participation p JOIN p.executor e WHERE e.name = :executorName")

    @Query("SELECT o.model FROM Offer o JOIN o.users u WHERE u.userName = :userName")
    List<Model> findModelsByUserName( String userName);
}