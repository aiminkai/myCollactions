package review.repository;


import review.model.DomainObject;

public interface Repository <T extends DomainObject> {

      void addToDb(String collection, Object obj);

      <T extends DomainObject> T getFromDb(String collection, String name);
}
