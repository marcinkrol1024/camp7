package sages.bootcamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "shops")
public class Shop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private String address;

  public Shop() {
  }

  public Shop(int id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Shop shop = (Shop) o;
    return id == shop.id &&
        Objects.equals(name, shop.name) &&
        Objects.equals(address, shop.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address);
  }

  @Override
  public String toString() {
    return "Shop{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
