package de.atomfrede.github.karaoke.server;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import de.atomfrede.github.karaoke.server.config.KaraokeConfiguration;
import de.atomfrede.github.karaoke.server.mongo.MongoHealthCheck;
import de.atomfrede.github.karaoke.server.mongo.SingerRepository;
import de.atomfrede.github.karaoke.server.resource.PingResource;
import de.atomfrede.github.karaoke.server.resource.SingerResource;
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
    public void run(KaraokeConfiguration configuration, Environment environment) throws Exception {

        System.out.println("Starting Karaoke Application");

        MongoClient mongo = new MongoClient(configuration.mongohost, configuration.mongoport);
        environment.healthChecks().register("MongoDB", new MongoHealthCheck(mongo));

        final SingerRepository singerRepository = new SingerRepository(new DB(mongo, configuration.mongodb));
        environment.lifecycle().manage(singerRepository);

        final SingerResource singerResource = new SingerResource(singerRepository);
        environment.jersey().register(singerResource);

        PingResource pingResource = new PingResource();

        environment.jersey().register(pingResource);
    }

}
