package edu.csumb.xtreme.movieticketing.criterias;

import edu.csumb.xtreme.movieticketing.entities.MovieEntity;
import java.util.List;

public interface Criteria {
    public List<MovieEntity> meetCriteria(List<MovieEntity> movies);
}
