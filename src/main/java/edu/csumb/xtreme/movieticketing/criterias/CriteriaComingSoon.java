package edu.csumb.xtreme.movieticketing.criterias;

import edu.csumb.xtreme.movieticketing.dao.MovieDao;
import edu.csumb.xtreme.movieticketing.entities.MovieEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.ArrayList;


public class CriteriaComingSoon implements Criteria{
    
  @Autowired
  MovieDao movieDao;
  
  
  @Override
  public List<MovieEntity> meetCriteria(List<MovieEntity> movies) {
      List<MovieEntity> comingSoon = new ArrayList<MovieEntity>();
      LocalDate currentDate = LocalDate.now();
      
      for (MovieEntity movie : movies) {
          if(movie.getReleaseDate().isAfter(currentDate)) {
              comingSoon.add(movie);
          }
      }
      return comingSoon;
  }
}
