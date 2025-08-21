package br.com.fiap;

import br.com.fiap.beans.Post;
import br.com.fiap.bo.PostBO;
import br.com.fiap.exceptions.*;
import br.com.fiap.model.PublicPost;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    private final PostBO postBO = new PostBO();

    @GET
    public ArrayList<PublicPost> getPosts() throws SQLException, ConnectionException {
        return  (ArrayList<PublicPost>)  postBO.selectAll();
    }

    @GET
    @Path("/{id}")
    public PublicPost getPost(@PathParam("id") int id) throws SQLException, ConnectionException {
        return  postBO.selectById(id);
    }

    @POST
    public Response insertPost(Post post) throws SQLException, InsertException, ConnectionException {
        PublicPost newPost = postBO.insert(post);
        return Response
            .status(Response.Status.CREATED)
            .entity(newPost)
            .build();
    }

    @PUT
    @Path("{id}")
    public Response updatePost(Post post, @PathParam("id") int id) throws SQLException, IncorrectKeyWordException, UpdateException, ConnectionException {
        PublicPost updatedPost = postBO.update(id, post);
        return Response
                .ok()
                .entity(updatedPost)
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePost (@PathParam("id") int id) throws SQLException, DeleteException, ConnectionException {
        postBO.delete(id);
        return Response.ok().build();
    }

}
