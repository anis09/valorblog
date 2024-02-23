package tn.valorant.valorblog.services;

import tn.valorant.valorblog.models.Post;

import tn.valorant.valorblog.models.Post;
import tn.valorant.valorblog.utils.MyDatabase;

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
        preparedStatement.setString(3, post.getPostImage());
        preparedStatement.executeUpdate();
    }

    @Override
    public void updatePost(Post post) throws SQLException {
        String sql = "UPDATE post SET post_content = ?, post_title = ?, post_likes = ?, post_image = ?, is_archived = ? WHERE post_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, post.getPostContent());
        preparedStatement.setString(2, post.getPostTitle());
        preparedStatement.setInt(3, post.getPostLikes());
        preparedStatement.setString(4, post.getPostImage());
        preparedStatement.setBoolean(5, post.isArchived());
        preparedStatement.setInt(6, post.getPostId());
        preparedStatement.executeUpdate();
    }


    @Override
    public void deletePost(int postId) throws SQLException {
        String sql = "UPDATE post SET is_archived = true WHERE post_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, postId);
            preparedStatement.executeUpdate();
        }
    }


        @Override
    public List<Post> getAll() throws SQLException {
        String sql = "SELECT * FROM post";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Post> posts = new ArrayList<>();
        while (rs.next()) {
            Post post = new Post();
            post.setPostId(Integer.parseInt(rs.getString("post_id")));
            post.setPostContent(rs.getString("post_content"));
            post.setPostTitle(rs.getString("post_title"));
            post.setPostLikes(rs.getInt("post_likes"));
            post.setPostImage(rs.getString("post_image"));
            post.setArchived(rs.getBoolean("is_archived"));

            posts.add(post);
        }
        return posts;
    }

    @Override
    public Post getById(int id) {
        return null;
    }
}