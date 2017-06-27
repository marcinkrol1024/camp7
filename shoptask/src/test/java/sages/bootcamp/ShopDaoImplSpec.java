package sages.bootcamp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sages.bootcamp.test.ResourcesManager;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ShopDaoImplSpec {

  private EntityManager entityManager = ResourcesManager.getEntityManager();

  @Before
  public void before() {
    entityManager.getTransaction().begin();
  }

  @After
  public void after() {
    entityManager.getTransaction().rollback();
  }

  @Test
  public void shouldAddAShop() {
    // given
    ShopDaoImpl shopDao = new ShopDaoImpl(entityManager);

    Shop addedShop = new Shop(0, "Biedronka", "Jerozolimskie");

    // when
    shopDao.save(addedShop);

    // then
    Assert.assertTrue(findAllShops().contains(addedShop));
  }

  @Test
  public void shouldAddShops() {
    // given
    ShopDaoImpl shopDao = new ShopDaoImpl(entityManager);

    List<Shop> addedShops = Arrays.asList(
        new Shop(0, "Biedronka", "Jerozolimskie"),
        new Shop(0, "Tesco", "Hoża")
    );

    // when
    shopDao.save(addedShops);

    // then
    Assert.assertTrue(findAllShops().containsAll(addedShops));
  }

  @Test
  public void shouldDeleteAShop() {
    // given
    ShopDaoImpl shopDao = new ShopDaoImpl(entityManager);

    // and some shop is in database
    Shop deletedShop = new Shop(0, "Biedronka", "Jerozolimskie");
    shopDao.save(deletedShop);

    // when
    shopDao.delete(deletedShop);

    // then
    Assert.assertTrue(!findAllShops().contains(deletedShop));
  }

  @Test
  public void shouldFindAShopByNameSubstring() {
    // given
    ShopDaoImpl shopDao = new ShopDaoImpl(entityManager);

    String shopNameSubstring = "onka";

    List<Shop> expectedShops = Arrays.asList(
        new Shop(0, "Biedronka", "Jerozolimskie"),
        new Shop(0, "SuperonkaMarket", "Ulica")
    );

    List<Shop> addedShops = new ArrayList<>();
    addedShops.add(new Shop(0, "Tesco", "Hoża"));
    addedShops.addAll(expectedShops);

    shopDao.save(addedShops);


    // when
    List<Shop> actualShops = shopDao.findByNameSubstring(shopNameSubstring);

    // then
    Assert.assertEquals(
        new HashSet<>(expectedShops),
        new HashSet<>(actualShops)
    );
  }

  private List<Shop> findAllShops() {
    return entityManager
        .createQuery("select s from Shop s", Shop.class)
        .getResultList();
  }

}