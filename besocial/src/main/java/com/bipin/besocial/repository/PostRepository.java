package com.bipin.besocial.repository;

import com.bipin.besocial.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
//    public List<Post> findByUserId(Integer id);
}
