package Smirnov.Social_API.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> images = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    public void addImage(String image) {
        this.images.add(image);
    }

    public void removeImage(String image) {
        this.images.remove(image);
    }
}
