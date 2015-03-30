package de.atomfrde.github.karaoke.server;

import de.atomfrde.github.karaoke.server.config.KaraokeConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class KaraokeApplication extends Application<KaraokeConfiguration> {

    public static void main(final String[] args) throws Exception {
        new KaraokeApplication().run(args);
    }

    @Override
    public void run(KaraokeConfiguration karaokeConfiguration, Environment environment) throws Exception {

        System.out.println("Starting Karaoke Application");
    }
}
