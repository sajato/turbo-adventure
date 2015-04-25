package de.atomfrede.github.karaoke.server.repository;

import java.io.Serializable;

public interface PagingRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

    Page<T> findAll(Pageable pageable);
}
