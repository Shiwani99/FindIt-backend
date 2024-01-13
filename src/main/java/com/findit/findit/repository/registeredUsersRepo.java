package com.findit.findit.repository;
import com.findit.findit.models.registeredUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface registeredUsersRepo extends JpaRepository<registeredUsers, Long> {

    
}
