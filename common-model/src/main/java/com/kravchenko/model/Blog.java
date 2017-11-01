package com.kravchenko.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Blog {

    @Id
    @Column(name = "blog_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "blog_name")
    @NonNull
    private String blogName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blog")
    private Set<BlogPost> posts = new HashSet<>();

    public void addPost(BlogPost post) {
        posts.add(post);
    }
}