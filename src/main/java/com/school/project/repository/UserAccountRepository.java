package com.school.project.repository;

import com.school.project.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    @Transactional
    void deleteUserAccountByUser_Id(Long id);
}
