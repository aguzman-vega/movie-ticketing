package edu.csumb.xtreme.movieticketing.criterias;

import edu.csumb.xtreme.movieticketing.dao.MovieDao;
import edu.csumb.xtreme.movieticketing.entities.MovieEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.ArrayList;



public class CriteriaNowPlaying implements Criteria{
    
    
    @Autowired
    MovieDao movieDao;
    
    
    @Override
    public List<MovieEntity> meetCriteria(List<MovieEntity> movies) {
        List<MovieEntity> nowPlaying = new ArrayList<MovieEntity>();
        LocalDate currentDate = LocalDate.now();
        
        for (MovieEntity movie : movies) {
            if(movie.getReleaseDate().isBefore(currentDate)) {
                nowPlaying.add(movie);
            }
        }
        return nowPlaying;
    }
}
