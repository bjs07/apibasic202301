package com.example.apibasic.jpabasic.repository;

import com.example.apibasic.jpabasic.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
