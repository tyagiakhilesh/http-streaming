package com.akhilesh.learning.client;

import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StreamTest {

    @Test
    public void test1() throws IOException {
        Client client = ClientBuilder.newClient();
        File f = new File("/tmp/a");
        try (FileInputStream fi = new FileInputStream(f)) {
            String r = client.target("http://localhost:8088")
                    .path("/service-one/v1/upload")
                    .request(MediaType.APPLICATION_OCTET_STREAM)
                    .accept(MediaType.TEXT_PLAIN)
                    .buildPost(Entity.entity(fi, MediaType.APPLICATION_OCTET_STREAM))
                    .invoke(String.class);
            System.out.println(r);
            client.close();
        }
    }
}
