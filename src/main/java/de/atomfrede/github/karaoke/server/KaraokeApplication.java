package de.atomfrede.github.karaoke.server;

import de.atomfrede.github.karaoke.server.config.KaraokeConfiguration;
import de.atomfrede.github.karaoke.server.resource.PingResource;
import io.dropwizard.Application;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class KaraokeApplication extends Application<KaraokeConfiguration> {

    public static void main(final String[] args) throws Exception {
        new KaraokeApplication().run(args);
    }

    @Override
    public void initialize(final Bootstrap<KaraokeConfiguration> bootstrap) {
        bootstrap.addBundle(new Java8Bundle());
    }

    @Override
    public void run(KaraokeConfiguration karaokeConfiguration, Environment environment) throws Exception {

        System.out.println("Starting Karaoke Application");

        PingResource pingResource = new PingResource();

        environment.jersey().register(pingResource);
    }
}
