package tn.valorant.valorblog.services;

import java.sql.SQLException;
import java.util.List;

public interface IServices<T> {
    List<T> getAll() throws SQLException;
    T getById(int id);
    void addPost(T t) throws SQLException;

    void updatePost(T t) throws SQLException;

    void deletePost(int postId) throws SQLException;
}
