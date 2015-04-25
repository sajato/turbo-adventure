package de.atomfrede.github.karaoke.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Singers {

    @JsonProperty
    private Iterable<Singer> singers;

    public Singers() {
    }

    public Singers(Iterable<Singer> singer) {
        this.singers = singer;
    }

    public Iterable<Singer> getSingers() {
        return singers;
    }

    public void setSingers(Iterable<Singer> singers) {
        this.singers = singers;
    }
}
