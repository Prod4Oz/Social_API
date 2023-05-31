package Smirnov.Social_API.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длиной")
    @Column(name = "username")
    private String username;
    @NotEmpty(message = "Email не должно быть пустым")
    @Column(name = "email")
    private String email;
    @NotEmpty(message = "Password не должно быть пустым")
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();
    @ManyToMany(mappedBy = "friends")
    private List<User> subscribers = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_friends", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private List<User> friends = new ArrayList<>();

    public void addPost(Post post) {
        this.posts.add(post);
        post.setUser(this);
    }

    public void removePost(Post post) {
        this.posts.remove(post);
        post.setUser(null);
    }

    public void addFriend(User friend) {
        this.friends.add(friend);
        friend.getSubscribers().add(this);
    }

    public void removeFriend(User friend) {
        this.friends.remove(friend);
        friend.getSubscribers().remove(this);
    }

}
