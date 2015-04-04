package de.atomfrede.github.karaoke.server.mongo;

import com.codahale.metrics.health.HealthCheck;
import com.mongodb.MongoClient;

public class MongoHealthCheck extends HealthCheck {

    private MongoClient mongo;

    public MongoHealthCheck(MongoClient mongo) {
        this.mongo = mongo;
    }

    @Override
    protected Result check() throws Exception {
        try {
            mongo.getDatabaseNames();
            return Result.healthy();
        } catch (Exception e) {
            return Result.unhealthy(e);
        }

    }
}
