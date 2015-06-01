package de.atomfrede.github.karaoke.server.mongo;

import com.mongodb.DB;
import de.atomfrede.github.karaoke.server.entity.Singer;
import de.atomfrede.github.karaoke.server.repository.CrudRepository;
import org.jongo.MongoCollection;

public class SingerRepository extends JongoManaged implements CrudRepository<Singer, String> {

    final String COLLECTION_NAME = "singers";
    final String ID_QUERY = "{_id:#}";

    MongoCollection collection;

    public SingerRepository(DB db) {
        super(db);
        collection = jongo.getCollection("singers");
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String s) {
        collection.remove(ID_QUERY, s);
    }

    @Override
    public void delete(Iterable<? extends Singer> entities) {

        entities.forEach(this::delete);
    }

    @Override
    public void delete(Singer entity) {
        collection.remove(ID_QUERY, entity.id());
    }

    @Override
    public void deleteAll() {
        collection.drop();
    }

    @Override
    public boolean exists(String s) {
        return findOne(s) != null;
    }

    @Override
    public Iterable<Singer> findAll() {
        return collection.find().as(Singer.class);
    }

    @Override
    public Iterable<Singer> findAll(Iterable<String> strings) {
        return null;
    }

    @Override
    public Singer findOne(String s) {
        return collection.findOne(ID_QUERY, s).as(Singer.class);
    }

    @Override
    public <S extends Singer> Iterable<S> save(Iterable<S> entities) {

        entities.forEach(this::save);
        return entities;
    }

    @Override
    public <S extends Singer> S save(S entity) {
        collection.save(entity);
        return entity;
    }

}
