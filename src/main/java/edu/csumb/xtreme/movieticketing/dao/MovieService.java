package edu.csumb.xtreme.movieticketing.dao;

import edu.csumb.xtreme.movieticketing.entities.MovieEntity;
import edu.csumb.xtreme.movieticketing.entities.MovieEntity.MovieEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class MovieService {
    
    @Autowired
    private MovieDao movieDao;

    public MovieEntity createMovie(String movieName, String director, String genre, String rating,
        LocalDate releaseDate, int runtime) {
        MovieEntity movieEntity = MovieEntityBuilder.aMovieEntity()
            .withName(movieName)
            .withDirector(director)
            .withGenre(genre)
            .withRating(rating)
            .withReleaseDate(releaseDate)
            .withRuntime(runtime).build();
        return movieDao.save(movieEntity);
    }
    
    public void deleteMovie(int id) {
        movieDao.deleteById(id);
    }

}
