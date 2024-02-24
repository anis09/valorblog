package tn.valorant.valorblog.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IServices<T> {
    List<T> getAll() throws SQLException;
    T getById(int id);
    void addPost(T t) throws SQLException;

    void updatePost(T t) throws SQLException, IOException;

    void deletePost(int postId) throws SQLException;
}
