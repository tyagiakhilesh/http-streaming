package com.akhilesh.learning.resources;

import com.akhilesh.learning.ServiceOneApplication;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@Path("service-one/v1/upload")
public class UploadResource {

    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    @Produces(MediaType.TEXT_PLAIN)
    public Response upload(InputStream inputStream) {
        Response response = ServiceOneApplication.httpClient.target("http://localhost:8098")
                .path("service-two/v1/consume")
                .request(MediaType.APPLICATION_OCTET_STREAM_TYPE)
                .buildPost(Entity.entity(inputStream, MediaType.APPLICATION_OCTET_STREAM_TYPE))
                .invoke();
        return Response.ok(response).entity("File streamed alright!").build();
    }
}
