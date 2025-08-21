package br.com.fiap.bo;

import br.com.fiap.beans.Post;
import br.com.fiap.dao.PostDAO;
import br.com.fiap.exceptions.*;
import br.com.fiap.model.PublicPost;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostBO {

    public ArrayList<PublicPost> selectAll() throws SQLException, ConnectionException {
        try (PostDAO postDAO = new PostDAO()) {
            List<Post> posts = postDAO.selectAll();

            ArrayList<PublicPost> publicPosts = new ArrayList<>();
            for (Post post : posts) {
                publicPosts.add(new PublicPost(post));
            }

            return publicPosts;
        }
    }

    public PublicPost selectById(int id) throws ConnectionException, SQLException {
        try (PostDAO postDAO = new PostDAO()) {
            Post post = postDAO.selectById(id);
            return new PublicPost(post);
        }
    }

    public PublicPost insert(Post post) throws SQLException, InsertException, ConnectionException {
        try (PostDAO postDAO = new PostDAO()) {
            int id = postDAO.insert(post);
            Post newPost = postDAO.selectById(id);

            return new PublicPost(newPost);
        }
    }

    public PublicPost update(int id, Post editedPost) throws SQLException, IncorrectKeyWordException, ConnectionException, UpdateException {
        try (PostDAO postDAO = new PostDAO()) {

            Post post = postDAO.selectById(id);
            if (!Objects.equals(editedPost.getKeyWord(), post.getKeyWord())) {
                throw new IncorrectKeyWordException();
            }
            postDAO.update(id, editedPost);
            Post updatedPost = postDAO.selectById(id);

            return new PublicPost(updatedPost);
        }
    }

    public void delete(int id) throws SQLException, ConnectionException, DeleteException {
        try (PostDAO postDAO = new PostDAO()) {
            postDAO.delete(id);
        }
    }

}
