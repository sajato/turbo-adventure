package de.atomfrede.github.karaoke.server.entity;

import org.jongo.marshall.jackson.oid.MongoId;

public class Singer {

    @MongoId
    private String _id;

    private String firstname;
    private String lastname;

    public String firstname() {
        return this.firstname;
    }

    public String lastname() {
        return this.lastname;
    }

    public Singer setFirstname(final String firstname) {
        this.firstname = firstname;
        return this;
    }

    public Singer setLastname(final String lastname) {
        this.lastname = lastname;
        return this;
    }


}
