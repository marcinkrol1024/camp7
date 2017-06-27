package sages.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class NotebookNamedQueryDao extends AbstractDaoImpl<Notebook> implements NotebookDao {

  public NotebookNamedQueryDao(EntityManager entityManager) {
    super(entityManager, Notebook.class);
  }

  @Override
  public List<Notebook> findByResolution(int resolution) {
    TypedQuery<Notebook> query = entityManager
        .createNamedQuery("get notebooks by resolution", Notebook.class);
    query.setParameter("resolution", resolution);
    return query.getResultList();
  }

  @Override
  public List<Notebook> findAllBySizeAndColour(int size, String colour) {
    beginTransaction();
    TypedQuery<Notebook> query = entityManager
        .createNamedQuery("get notebooks for sizeInInches and colour", Notebook.class);
    query.setParameter("size", size);
    query.setParameter("colour", colour);
    List<Notebook> resultList = query.getResultList();
    commitTransaction();
    return resultList;

  }


}
