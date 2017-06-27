package sages.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class NotebookCriteriaDao extends AbstractDaoImpl<Notebook> implements NotebookDao {

  public NotebookCriteriaDao(EntityManager entityManager) {
    super(entityManager, Notebook.class);
  }

  @Override
  public List<Notebook> findByResolution(int resolution) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Notebook> query = cb.createQuery(Notebook.class);
    Root<Notebook> from = query.from(Notebook.class);
    query.where(cb.equal(from.get(Notebook_.resolution), resolution));
    return entityManager.createQuery(query).getResultList();
  }

  @Override
  public List<Notebook> findAllBySizeAndColour(int size, String colour) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Notebook> query = cb.createQuery(Notebook.class);
    Root<Notebook> from = query.from(Notebook.class);
    query.where(
        cb.and(
            cb.equal(from.get(Notebook_.sizeInInches), size),
            cb.equal(from.get(Notebook_.colour), colour)
        )
    );
    return entityManager.createQuery(query).getResultList();
  }


}
