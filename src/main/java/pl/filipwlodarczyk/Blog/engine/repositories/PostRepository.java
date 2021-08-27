package pl.filipwlodarczyk.Blog.engine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.filipwlodarczyk.Blog.engine.models.Post;

public interface PostRepository extends JpaRepository<Post,  Long> {
}
