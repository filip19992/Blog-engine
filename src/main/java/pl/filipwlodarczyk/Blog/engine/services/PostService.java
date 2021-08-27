package pl.filipwlodarczyk.Blog.engine.services;

import org.springframework.stereotype.Service;
import pl.filipwlodarczyk.Blog.engine.models.Post;
import pl.filipwlodarczyk.Blog.engine.repositories.PostRepository;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findPostById(Long id){

       try {
           return postRepository.findById(id);
       } catch(Exception e) {
           throw new IllegalStateException(String.format("User witd id %s has been not found", id));
        }
}
}
