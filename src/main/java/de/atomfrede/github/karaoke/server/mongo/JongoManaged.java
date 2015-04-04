package de.atomfrede.github.karaoke.server.mongo;

import com.mongodb.DB;
import io.dropwizard.lifecycle.Managed;
import org.jongo.Jongo;

public class JongoManaged implements Managed {

    DB db;

    Jongo jongo;

    public JongoManaged(DB db) {
        this.db = db;
        jongo = new Jongo(db);
    }

    @Override
    public void start() throws Exception {


    }

    @Override
    public void stop() throws Exception {

        db.getMongo().close();
    }
}
