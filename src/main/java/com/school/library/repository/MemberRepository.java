package com.school.library.repository;

import com.school.library.entity.Member;
import com.school.library.model.response.MemberRs;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    boolean existsByEmail(@Email @Size(max = 100) String email);
    Member findByEmail(@Email @Size(max = 100) String email);
    Member findMemberById(Long id);
    boolean existsById(Long id);
}
