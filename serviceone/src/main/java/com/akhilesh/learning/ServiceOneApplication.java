package com.akhilesh.learning;

import com.akhilesh.learning.resources.UploadResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class ServiceOneApplication extends Application<ServiceOneConfiguration> {

    public static Client httpClient = ClientBuilder.newClient();

    public static void main(final String[] args) throws Exception {
        new ServiceOneApplication().run(args);

    }

    @Override
    public String getName() {
        return "serviceone";
    }

    @Override
    public void initialize(final Bootstrap<ServiceOneConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ServiceOneConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new UploadResource());
    }

}
