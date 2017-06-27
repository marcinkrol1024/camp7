package sages.bootcamp;

import java.util.List;

public interface NotebookDao extends AbstractDao<Notebook>{

    List findByResolution(int resolution);

    List<Notebook> findAllBySizeAndColour(int size, String colour);


}
