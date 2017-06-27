package sages.bootcamp.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ResourcesManager {
  private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
  private static EntityManager entityManager = entityManagerFactory.createEntityManager();

  public static EntityManager getEntityManager() {
    return entityManager;
  }
}
