package com.akhilesh.learning.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@Path("service-two/v1/consume")
public class ConsumeResource {

    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public Response consume(InputStream inputStream) {
        File f = new File("/tmp/" + new Date().getTime());
        System.out.println("Writing to the file. " + f.getAbsolutePath());
        try (FileOutputStream fileOutputStream = new FileOutputStream(f)) {
            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Response.ok().build();
    }
}
