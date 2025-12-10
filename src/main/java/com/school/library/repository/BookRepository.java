package com.school.library.repository;

import com.school.library.entity.Book;
import com.school.library.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    boolean existsByName(String name);
}
