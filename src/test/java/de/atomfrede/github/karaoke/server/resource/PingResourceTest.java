package de.atomfrede.github.karaoke.server.resource;

import de.atomfrede.github.karaoke.server.entity.Pong;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class PingResourceTest {


    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PingResource()).build();

    @Test
    public void shouldReturnNewPong() {

        Pong p = resources.client().target("/ping/pong").request().get(Pong.class);

        assertThat(p, notNullValue());
        assertThat(p.msg, is("Pong"));

    }
}
