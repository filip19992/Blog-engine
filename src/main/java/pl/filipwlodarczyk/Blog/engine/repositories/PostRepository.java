package pl.filipwlodarczyk.Blog.engine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.filipwlodarczyk.Blog.engine.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,  Long> {
}
