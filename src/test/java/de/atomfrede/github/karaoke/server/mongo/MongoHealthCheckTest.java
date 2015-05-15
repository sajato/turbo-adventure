package de.atomfrede.github.karaoke.server.mongo;

import com.codahale.metrics.health.HealthCheck;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoIterable;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JMockit.class)
public class MongoHealthCheckTest {

    @Mocked
    MongoClient mongoClient;
    @Mocked
    MongoIterable mongoIterable;

    @Test
    public void shouldBeHealthy() throws Exception {

        new NonStrictExpectations() {{

            mongoClient.listDatabaseNames();
            result = mongoIterable;

            mongoIterable.first();
            result = "DB";
        }};

        MongoHealthCheck check = new MongoHealthCheck(mongoClient);

        assertThat(check.check(), is(HealthCheck.Result.healthy()));

    }

    @Test
    public void shouldBeUnhealty() throws Exception {

        new NonStrictExpectations() {{

            mongoClient.listDatabaseNames();
            result = new Exception("MongoDB error");
        }};

        MongoHealthCheck check = new MongoHealthCheck(mongoClient);

        assertThat(check.check().isHealthy(), is(false));
    }
}
