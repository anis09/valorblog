package tn.valorant.valorblog.services;

import java.sql.SQLException;
import java.util.List;

public interface ICommentServices<T> {
    List<T> getAllComments() throws SQLException;
    T getById(int id);
    void addComment(T t) throws SQLException;

    void updateComment(T t) throws SQLException;

    void deleteComment(int commentId) throws SQLException;
}
