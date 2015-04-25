package de.atomfrede.github.karaoke.server.mongo;

import com.mongodb.DB;
import de.atomfrede.github.karaoke.server.entity.Singer;
import de.atomfrede.github.karaoke.server.repository.CrudRepository;

public class SingerRepository extends JongoManaged implements CrudRepository<Singer, String> {


    public SingerRepository(DB db) {
        super(db);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void delete(Iterable<? extends Singer> entities) {

    }

    @Override
    public void delete(Singer entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public boolean exists(String s) {
        return false;
    }

    @Override
    public Iterable<Singer> findAll() {
        return null;
    }

    @Override
    public Iterable<Singer> findAll(Iterable<String> strings) {
        return null;
    }

    @Override
    public Singer findOne(String s) {
        return null;
    }

    @Override
    public <S extends Singer> Iterable<S> save(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Singer> S save(S entity) {
        return null;
    }

}
