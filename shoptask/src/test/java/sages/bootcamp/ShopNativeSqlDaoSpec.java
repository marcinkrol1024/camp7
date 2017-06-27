package sages.bootcamp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sages.bootcamp.test.ResourcesManager;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class ShopNativeSqlDaoSpec {

  private EntityManager entityManager = ResourcesManager.getEntityManager();

  @Before
  public void before() {
    entityManager.getTransaction().begin();
    entityManager.createQuery("delete from Shop").executeUpdate();
    entityManager.getTransaction().commit();
  }

  @Test
  public void shouldCalculateSumOfSquareMetersForANameSubstring() {
    // given
    ShopNativeSqlDao shopDao = new ShopNativeSqlDao(entityManager);

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

}