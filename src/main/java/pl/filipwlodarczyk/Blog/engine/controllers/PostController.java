package pl.filipwlodarczyk.Blog.engine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.filipwlodarczyk.Blog.engine.models.Post;
import pl.filipwlodarczyk.Blog.engine.services.PostService;

import java.util.Optional;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public Optional<Post> getPostById(Long id) {
       return postService.findPostById(id);
    }
}
