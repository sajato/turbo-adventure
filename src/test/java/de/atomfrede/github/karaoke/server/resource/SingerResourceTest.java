package de.atomfrede.github.karaoke.server.resource;

import com.mongodb.DB;
import de.atomfrede.github.karaoke.server.entity.Singer;
import de.atomfrede.github.karaoke.server.entity.Singers;
import de.atomfrede.github.karaoke.server.mongo.JongoManaged;
import de.atomfrede.github.karaoke.server.mongo.MongoHealthCheck;
import de.atomfrede.github.karaoke.server.mongo.SingerRepository;
import io.dropwizard.testing.junit.ResourceTestRule;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.integration.junit4.JMockit;
import org.jongo.Jongo;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JMockit.class)
public class SingerResourceTest {


    @Mocked
    static DB db;
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new SingerResource(new SingerRepository(db))).build();
    @Mocked
    JongoManaged jongoManaged;
    @Mocked
    MongoHealthCheck mongoHealthCheck;
    @Mocked
    Jongo jongo;
    @Mocked
    SingerRepository repository;

    @Test
    public void shouldGetAllSingers() {

        Singer johnDoe = new Singer().setFirstname("John").setLastname("Doe");
        Singer janeDoe = new Singer().setFirstname("Jane").setLastname("Doe");

        new NonStrictExpectations() {{
            repository.findAll();
            result = Arrays.asList(johnDoe, janeDoe);
        }};

        Singers singers = resources.client().target("/singer").request().get(Singers.class);

        assertThat(singers.getSingers(), notNullValue());

    }

    @Test
    public void shouldGetSingleSinger() {

        new NonStrictExpectations() {{
            repository.findOne("123");
            result = new Singer("123").setFirstname("John").setLastname("Doe");
        }};

        Singer singer = resources.client().target("/singer/123").request().get(Singer.class);

        assertThat(singer, notNullValue());
        assertThat(singer.firstname(), is("John"));
        assertThat(singer.lastname(), is("Doe"));
    }

}
