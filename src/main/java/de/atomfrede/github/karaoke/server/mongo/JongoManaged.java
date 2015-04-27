package de.atomfrede.github.karaoke.server.mongo;

import com.mongodb.DB;
import io.dropwizard.Configuration;
import io.dropwizard.lifecycle.Managed;
import org.jongo.Jongo;

public class JongoManaged implements Managed {

    DB db;

    Jongo jongo;

    Configuration configuration;

    public JongoManaged(DB db, Configuration configuration) {
        this.db = db;
        jongo = new Jongo(db);
        this.configuration = configuration;
    }

    @Override
    public void start() throws Exception {


    }

    @Override
    public void stop() throws Exception {

        db.getMongo().close();
    }
}
