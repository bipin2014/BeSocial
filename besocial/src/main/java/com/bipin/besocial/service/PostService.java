package com.bipin.besocial.service;

import com.bipin.besocial.domain.Post;
import com.bipin.besocial.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void deleteById(Integer id) {
        postRepository.deleteById(id);

    }

    public Post findById(Integer id) {
        return postRepository.findById(id).get();
    }

    public Post edit(Integer id, Post post) {
        Post editPost = findById(id);
        editPost.setTitle(post.getTitle());
        editPost.setDescription(post.getDescription());
        editPost.setImageUrl(post.getImageUrl());

        return postRepository.save(editPost);
    }
}
