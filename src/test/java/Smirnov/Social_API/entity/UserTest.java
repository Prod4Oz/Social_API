package Smirnov.Social_API.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {


    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(1L);
        user.setUsername("user1");
        user.setEmail("user1@example.com");
        user.setPassword("password1");
    }

    @AfterEach
    public void tearDown() {
        user = null;
    }

    @Test
    void addPost() {
        Post post = new Post();
        user.addPost(post);
        assertEquals(1, user.getPosts().size());
        assertTrue(user.getPosts().contains(post));
        assertEquals(user, post.getUser());
    }

    @Test
    void removePost() {
        Post post = new Post();
        user.addPost(post);
        user.removePost(post);
        assertEquals(0, user.getPosts().size());
        assertFalse(user.getPosts().contains(post));
        assertNull(post.getUser());
    }

    @Test
    void addFriend() {
        User friend = new User();
        user.addFriend(friend);
        assertEquals(1, user.getFriends().size());
        assertTrue(user.getFriends().contains(friend));
        assertEquals(user, friend.getSubscribers().get(0));
    }

    @Test
    void removeFriend() {
        User friend = new User();
        user.addFriend(friend);
        user.removeFriend(friend);
        assertEquals(0, user.getFriends().size());
        assertFalse(user.getFriends().contains(friend));
        assertEquals(0, friend.getSubscribers().size());
    }
}