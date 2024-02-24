package tn.valorant.valorblog.services;

import javafx.scene.image.Image;
import tn.valorant.valorblog.models.Post;
import tn.valorant.valorblog.utils.MyDatabase;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostService implements IServices<Post> {

    private final Connection connection;

    public PostService() {
        connection = MyDatabase.getInstance().getConnection();
    }

    @Override
    public void addPost(Post post) throws SQLException {
        String sql = "INSERT INTO post (post_content, post_title, post_image) " +
                "VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, post.getPostContent());
        preparedStatement.setString(2, post.getPostTitle());
        preparedStatement.setString(3, post.getImagePath());
        preparedStatement.executeUpdate();
    }

    @Override
    public void updatePost(Post post) throws SQLException {
        // Your updatePost method remains the same
    }

    @Override
    public void deletePost(int postId) throws SQLException {
        // Your deletePost method remains the same
    }

    @Override
    public List<Post> getAll() throws SQLException {
        String sql = "SELECT * FROM post";
        List<Post> posts = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Post post = new Post();
                post.setPostId(rs.getInt("post_id"));
                post.setPostContent(rs.getString("post_content"));
                post.setPostTitle(rs.getString("post_title"));
                post.setPostLikes(rs.getInt("post_likes"));
                post.setArchived(rs.getBoolean("is_archived"));

                // Convert Blob to Image
                Blob blob = rs.getBlob("post_image");
                if (blob != null) {
                    try (ByteArrayInputStream bis = new ByteArrayInputStream(blob.getBytes(1, (int) blob.length()))) {
                        Image image = new Image(bis);
                        post.setPostImage(image);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                posts.add(post);
            }
        }
        return posts;
    }


    @Override
    public Post getById(int id) {
        return null;
    }
}