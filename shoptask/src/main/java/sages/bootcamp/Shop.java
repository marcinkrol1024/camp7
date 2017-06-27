package sages.bootcamp;

import javax.persistence.Column;
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

  @Column(unique = true)
  private String name;

  private String address;

  private int squareMeters;

  public Shop() {
  }

  public Shop(int id, String name, String address, int squareMeters) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.squareMeters = squareMeters;
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


  public int getSquareMeters() {
    return squareMeters;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Shop shop = (Shop) o;
    return id == shop.id &&
        squareMeters == shop.squareMeters &&
        Objects.equals(name, shop.name) &&
        Objects.equals(address, shop.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address, squareMeters);
  }

  @Override
  public String toString() {
    return "Shop{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", squareMeters=" + squareMeters +
        '}';
  }
}
