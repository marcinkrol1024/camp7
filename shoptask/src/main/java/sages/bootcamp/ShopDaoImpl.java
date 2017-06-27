package sages.bootcamp;

import javax.persistence.EntityManager;
import java.util.List;

public class ShopDaoImpl implements ShopDao {

  private final EntityManager entityManager;

  public ShopDaoImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public void save(Shop shop) {

  }

  @Override
  public void save(List<Shop> shops) {

  }

  @Override
  public void delete(Shop entity) {

  }

  @Override
  public List<Shop> findByNameSubstring(String nameSubstring) {
    return null;
  }
}
