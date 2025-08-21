package br.com.fiap.dao;

import br.com.fiap.beans.Post;
import br.com.fiap.connections.ConnectionFactory;
import br.com.fiap.exceptions.ConnectionException;
import br.com.fiap.exceptions.DeleteException;
import br.com.fiap.exceptions.InsertException;
import br.com.fiap.exceptions.UpdateException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO implements AutoCloseable {

    protected Connection con;

    public PostDAO() throws ConnectionException {
        this.con = ConnectionFactory.getConnection();
    }

    public Connection getConnection() {
        return this.con;
    }

    @Override
    public void close() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public List<Post> selectAll() throws SQLException {
        String sql = "SELECT id, author, creation_date, update_date, title, post_content, key_word FROM post ORDER BY id";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                List<Post> posts = new ArrayList<Post>();

                while (rs.next()) {
                    Post post = new Post();

                    post.setId(rs.getInt("id"));
                    post.setAuthor(rs.getString("author"));
                    post.setCreationDate(rs.getTimestamp("creation_date").toLocalDateTime());
                    post.setUpdateDate(rs.getTimestamp("update_date").toLocalDateTime());
                    post.setTitle(rs.getString("title"));
                    post.setPostContent(rs.getString("post_content"));
                    post.setKeyWord(rs.getString("key_word"));

                    posts.add(post);
                }

                return posts;
            }

        }
    }

    public Post selectById(int id) throws SQLException {
        String sql = "SELECT id, author, creation_date, update_date, title, post_content, key_word FROM post WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Post post = new Post();

                    post.setId(rs.getInt("id"));
                    post.setAuthor(rs.getString("author"));
                    post.setCreationDate(rs.getTimestamp("creation_date").toLocalDateTime());
                    post.setUpdateDate(rs.getTimestamp("update_date").toLocalDateTime());
                    post.setTitle(rs.getString("title"));
                    post.setPostContent(rs.getString("post_content"));
                    post.setKeyWord(rs.getString("key_word"));

                    return post;
                }

                return null;
            }
        }
    }

    public int insert(Post post) throws InsertException {
        String sqlCommand = "INSERT INTO post (author, title, post_content, key_word) VALUES  (?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sqlCommand, new String[] { "id" })) {
            stmt.setString(1, post.getAuthor());
            stmt.setString(2, post.getTitle());
            stmt.setString(3, post.getPostContent());
            stmt.setString(4, post.getKeyWord());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new InsertException("Failed to insert user");
            }

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    throw new InsertException("Failed to retrieve generated ID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InsertException("SQL error while inserting post: " + e.getMessage(), e);
        }
    }

    public void update(int id, Post post) throws UpdateException {
        String sql = "UPDATE post SET author = ?, update_date = ?, title = ?, post_content = ? WHERE id = ?;";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, post.getAuthor());
            stmt.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
            stmt.setString(3, post.getTitle());
            stmt.setString(4, post.getPostContent());

            stmt.setInt(5, id);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new UpdateException("Failed to update post");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UpdateException("SQL error while updating post: " + e.getMessage(), e);
        }
    }

    public void delete(int id) throws DeleteException {
        String sql = "DELETE FROM post WHERE id = ?;";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new DeleteException("Failed to delete post");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DeleteException("SQL error while deleting post: " + e.getMessage(), e);
        }
    }

}
