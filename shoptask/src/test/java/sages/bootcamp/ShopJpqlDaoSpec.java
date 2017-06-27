package sages.bootcamp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sages.bootcamp.test.ResourcesManager;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ShopJpqlDaoSpec {

  private EntityManager entityManager = ResourcesManager.getEntityManager();

  @Before
  public void before() {
    entityManager.getTransaction().begin();
    entityManager.createQuery("delete from Shop").executeUpdate();
    entityManager.getTransaction().commit();
  }

  @Test
  public void shouldAddAShop() {
    // given
    ShopJpqlDao shopDao = new ShopJpqlDao(entityManager);

    Shop addedShop = new Shop(0, "Biedronka", "Jerozolimskie", 7);

    // when
    shopDao.save(addedShop);

    // then
    Assert.assertTrue(findAllShops().contains(addedShop));
  }

  @Test
  public void shouldAddShops() {
    // given
    ShopJpqlDao shopDao = new ShopJpqlDao(entityManager);

    List<Shop> addedShops = Arrays.asList(
        new Shop(0, "Biedronka", "Jerozolimskie", 1),
        new Shop(0, "Tesco", "Hoża", 2)
    );

    // when
    shopDao.save(addedShops);

    // then
    Assert.assertTrue(findAllShops().containsAll(addedShops));
  }

  @Test
  public void shouldDeleteAShop() {
    // given
    ShopJpqlDao shopDao = new ShopJpqlDao(entityManager);

    // and some shop is in database
    Shop deletedShop = new Shop(0, "Biedronka", "Jerozolimskie", 3);
    shopDao.save(deletedShop);

    // when
    shopDao.delete(deletedShop);

    // then
    Assert.assertTrue(!findAllShops().contains(deletedShop));
  }

  @Test
  public void shouldFindAShopByNameSubstring() {
    // given
    ShopJpqlDao shopDao = new ShopJpqlDao(entityManager);

    String shopNameSubstring = "onka";

    List<Shop> expectedShops = Arrays.asList(
        new Shop(0, "Biedronka", "Jerozolimskie", 4),
        new Shop(0, "SuperonkaMarket", "Ulica", 5)
    );

    List<Shop> addedShops = new ArrayList<>();
    addedShops.add(new Shop(0, "Tesco", "Hoża", 6));
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

  @Test
  public void shouldCalculateSumOfSquareMetersForANameSubstring() {
    // given
    ShopJpqlDao shopDao = new ShopJpqlDao(entityManager);

    String nameSubstring = "onka";
    List<Shop> shops = Arrays.asList(
        new Shop(0, "Biedronka", "Jerozolimskie", 4),
        new Shop(0, "SuperonkaMarket", "Ulica", 5),
        new Shop(0, "Tesco", "Hoża", 6)
    );
    shopDao.save(shops);

    BigInteger expectedSumOfSquareMeters = BigInteger.valueOf(9);

    // when
    BigInteger actualSumOfSquareMeters = shopDao.sumSquareMetersForNameSubstring(nameSubstring);

    // then
    Assert.assertEquals(expectedSumOfSquareMeters, actualSumOfSquareMeters);
  }


  private List<Shop> findAllShops() {
    return entityManager
        .createQuery("select s from Shop s", Shop.class)
        .getResultList();
  }

}