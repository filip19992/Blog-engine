package pl.filipwlodarczyk.Blog.engine.models;

import javax.persistence.*;

@Entity(name = "posts")
@Table(name = "posts")
public class Post {

    @Id
    @SequenceGenerator(name = "postId_sequence", sequenceName = "postId_sequence", allocationSize = 1)
    @GeneratedValue(generator = "postId_sequence", strategy = GenerationType.SEQUENCE)
    private Long postId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User userId;
    @Column
    private String content;


}
