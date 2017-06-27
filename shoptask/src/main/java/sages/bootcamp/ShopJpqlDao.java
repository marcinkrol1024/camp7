package sages.bootcamp;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;

public class ShopJpqlDao implements ShopDao {

  private final EntityManager entityManager;

  public ShopJpqlDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public void save(Shop shop) {
    entityManager.getTransaction().begin();
    entityManager.persist(shop);
    entityManager.getTransaction().commit();
  }

  @Override
  public void save(List<Shop> shops) {
    entityManager.getTransaction().begin();
    for (Shop shop : shops) {
      entityManager.persist(shop);
    }
    entityManager.getTransaction().commit();
  }

  @Override
  public void delete(Shop shop) {
    entityManager.getTransaction().begin();
    entityManager.remove(shop);
    entityManager.getTransaction().commit();
  }

  @Override
  public List<Shop> findByNameSubstring(String nameSubstring) {
    return entityManager
        .createQuery("select s from Shop s where s.name like :name", Shop.class)
        .setParameter("name", "%" + nameSubstring + "%")
        .getResultList();
  }

  @Override
  public BigInteger sumSquareMetersForNameSubstring(String nameSubstring) {
    return BigInteger.valueOf(
        (Long) entityManager
            .createQuery("select sum(s.squareMeters) from Shop s where s.name like :nameSubstring")
            .setParameter("nameSubstring", "%" + nameSubstring + "%")
            .getSingleResult()
    );
  }
}
