package tn.valorant.valorblog.services;



import tn.valorant.valorblog.models.Comment;
import tn.valorant.valorblog.services.ICommentServices;
import tn.valorant.valorblog.utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentService implements ICommentServices<Comment> {
    private Connection connection;

    public CommentService() {
        connection = MyDatabase.getInstance().getConnection();
    }

    @Override
    public void addComment(Comment comment) throws SQLException {
        String sql = "INSERT INTO comment (comment_content, post_id, comment_createdBy) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, comment.getCommentContent());
            preparedStatement.setInt(2, comment.getPostId());
            preparedStatement.setString(3, comment.getCommentCreatedBy());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateComment(Comment comment) throws SQLException {
        String sql = "UPDATE comment SET comment_content = ?, post_id = ?, comment_createdBy = ? WHERE comment_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, comment.getCommentContent());
            preparedStatement.setInt(2, comment.getPostId());
            preparedStatement.setString(3, comment.getCommentCreatedBy());
            preparedStatement.setInt(4, comment.getCommentId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteComment(int id) throws SQLException {
        String sql = "DELETE FROM comment WHERE comment_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Comment> getAllComments() throws SQLException {
        String sql = "SELECT * FROM comment";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Comment> comments = new ArrayList<>();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setCommentId(resultSet.getInt("comment_id"));
                comment.setCommentContent(resultSet.getString("comment_content"));
                comment.setPostId(resultSet.getInt("post_id"));
                comment.setCommentCreatedBy(resultSet.getString("comment_createdBy"));
                comments.add(comment);
            }
            return comments;
        }
    }

    @Override
    public Comment getById(int id) {
        return null;
    }
}
