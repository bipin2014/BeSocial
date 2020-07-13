package com.bipin.besocial.resource;

import com.bipin.besocial.domain.Post;
import com.bipin.besocial.domain.User;
import com.bipin.besocial.service.PostService;
import com.bipin.besocial.service.UserService;
import com.bipin.besocial.storage.FileSystemStorageService;
import com.bipin.besocial.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/post")
@CrossOrigin
public class PostResource {
    private PostService postService;

    @Autowired
    private StorageService storageService;
    @Autowired
    private UserService userService;

    @Autowired
    PostResource(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<Post> getPosts() {
        return postService.findAll();
    }

    @PostMapping("/addPost/{userId}")
    public Post addPost(@PathVariable Integer userId,@RequestParam("image") MultipartFile file, @RequestParam("title") String title, @RequestParam("description") String description) {
        String imageUrl = storageService.store(file);
        System.out.println(file.getOriginalFilename());
        User user=userService.findById(userId);
        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);
        post.setImageUrl(imageUrl);
        post.setUser(user);
        return postService.save(post);
    }

    @PutMapping("/editPost/{id}")
    public Post editPost(@PathVariable Integer id, @RequestParam(value = "image", required = false) MultipartFile file, @RequestParam("title") String title, @RequestParam("description") String description) {
        Post editPost = postService.findById(id);
        if (file != null) {
            storageService.delete(editPost.getImageUrl());
            String filename = storageService.store(file);
            editPost.setImageUrl(filename);
        }
        editPost.setTitle(title);
        editPost.setDescription(description);
        return postService.edit(id, editPost);
    }


}
