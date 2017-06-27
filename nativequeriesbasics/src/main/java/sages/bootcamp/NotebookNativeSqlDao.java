package sages.bootcamp;

import javax.persistence.EntityManager;
import java.util.List;

public class NotebookNativeSqlDao extends AbstractDaoImpl<Notebook> implements NotebookDao {

  public NotebookNativeSqlDao(EntityManager entityManager) {
    super(entityManager, Notebook.class);
  }

  @Override
  public List<Notebook> findByResolution(int resolution) {
    //noinspection unchecked
    return entityManager
        .createNativeQuery(
            "select * from notebooks where resolution = :resolution",
            Notebook.class
        )
        .setParameter("resolution", resolution)
        .getResultList();
  }

  @Override
  public List<Notebook> findAllBySizeAndColour(int size, String colour) {
    //noinspection unchecked
    return entityManager
        .createNativeQuery(
            "select * from notebooks where sizeininches = :size and colour = :colour",
            Notebook.class
        )
        .setParameter("size", size)
        .setParameter("colour", colour)
        .getResultList();
  }


}
