package sages.bootcamp;

import java.util.List;

public interface ShopDao {
  void save(Shop shop);

  void save(List<Shop> shops);

  void delete(Shop entity);

  List<Shop> findByNameSubstring(String nameSubstring);
}
