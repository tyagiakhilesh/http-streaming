package com.akhilesh.learning;

import com.akhilesh.learning.resources.ConsumeResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ServiceTwoApplication extends Application<ServiceTwoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ServiceTwoApplication().run(args);
    }

    @Override
    public String getName() {
        return "servicetwo";
    }

    @Override
    public void initialize(final Bootstrap<ServiceTwoConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ServiceTwoConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new ConsumeResource());
    }

}
