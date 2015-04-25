package de.atomfrede.github.karaoke.server.repository;

public interface Pageable {

    Pageable first();

    int getOffset();

    int getPageNumber();


    int getPageSize();

    boolean hasPrevious();

    Pageable next();

    Pageable previousOrFirst();
}
