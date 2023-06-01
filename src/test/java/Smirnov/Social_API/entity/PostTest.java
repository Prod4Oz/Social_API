package Smirnov.Social_API.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    private Post post;

    @BeforeEach
    void setUp() {
        post = new Post();
        post.setId(1L);
        post.setTitle("Test Post");
        post.setText("Test Text");
        post.setCreatedAt(new Date());
        post.setUpdatedAt(new Date());
        List<String> images = new ArrayList<>();
        images.add("image1.jpg");
        images.add("image2.png");
        post.setImages(images);
    }

    @Test
    void addImage() {
        int imagesCountBefore = post.getImages().size();
        post.addImage("image3.jpg");
        assertEquals(imagesCountBefore + 1, post.getImages().size());
        assertTrue(post.getImages().contains("image3.jpg"));
    }

    @Test
    void removeImage() {
        int imagesCountBefore = post.getImages().size();
        post.removeImage("image1.jpg");
        assertEquals(imagesCountBefore - 1, post.getImages().size());
        assertFalse(post.getImages().contains("image1.jpg"));
    }
}