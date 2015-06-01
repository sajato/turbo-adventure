package de.atomfrede.github.karaoke.server.resource;

import com.codahale.metrics.annotation.Timed;
import de.atomfrede.github.karaoke.server.entity.Singer;
import de.atomfrede.github.karaoke.server.entity.Singers;
import de.atomfrede.github.karaoke.server.mongo.SingerRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/singer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SingerResource {

    private final SingerRepository singerRepository;

    public SingerResource(final SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    @GET
    @Timed
    public Singers getSingers() {

        return new Singers(singerRepository.findAll());
    }

    @GET
    @Timed
    @Path("{id}")
    public Singer getSinger(@PathParam("id") final String id) {

        Singer singer = singerRepository.findOne(id);

        if (singer != null) {
            return singer;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
}
