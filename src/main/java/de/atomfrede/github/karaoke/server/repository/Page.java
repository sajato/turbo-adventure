package de.atomfrede.github.karaoke.server.repository;

public interface Page<T> extends Iterable<T> {

    long getTotalElements();

    int getTotalPages();
}
