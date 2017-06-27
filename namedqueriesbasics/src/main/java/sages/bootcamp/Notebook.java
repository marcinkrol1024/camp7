package sages.bootcamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "notebooks")
@NamedQueries(
    value = {
        @NamedQuery(
            name = "get notebooks by resolution",
            query = "select n from Notebook n where n.resolution = :resolution"
        ),
        @NamedQuery(
            name = "get notebooks for sizeInInches and colour",
            query = "select n from Notebook n where n.sizeInInches = :size and n.colour = :colour"
        )
    }
)
public class Notebook {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private final String model;
  private final int resolution;
  private final int sizeInInches;
  private final String colour;
  private final Instant productionTimestamp;

  public Notebook(String model, int resolution, int sizeInInches, String colour, Instant productionTimestamp) {
    this.id = 0;
    this.model = model;
    this.resolution = resolution;
    this.sizeInInches = sizeInInches;
    this.colour = colour;
    this.productionTimestamp = productionTimestamp;
  }

  public int getId() {
    return id;
  }

  public String getModel() {
    return model;
  }

  public int getResolution() {
    return resolution;
  }

  public int getSizeInInches() {
    return sizeInInches;
  }

  public String getColour() {
    return colour;
  }

  public Instant getProductionTimestamp() {
    return productionTimestamp;
  }

  @Override
  public String toString() {
    return "Notebook{" +
        "id=" + id +
        ", model='" + model + '\'' +
        ", resolution=" + resolution +
        ", productionTimestamp=" + productionTimestamp +
        '}';
  }
}
