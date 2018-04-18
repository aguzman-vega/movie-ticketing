
import edu.csumb.xtreme.movieticketing.dao.MovieDao;
	import edu.csumb.xtreme.movieticketing.dao.MovieService;
	import edu.csumb.xtreme.movieticketing.entities.MovieEntity;
	import org.junit.Assert;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.junit4.SpringRunner;
	 
	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class MovieServiceTest {
@Autowired
	    MovieDao MovieDao;
	 
	    @Autowired
	    MovieService MovieService;
	 
	    @Test

	public void createMovie()								
    MovieEntity Movie = MovieService.createMovie("newMovie");
	        MovieEntity reqMovie = MovieDao.getOne(Movie.getId());
	        Assert.assertEquals(Movie.getId(), reqMovie.getId());
	    }
  @Test
	    public void deleteMovie() {
	        long beforeAdd = MovieDao.count();
	        MovieEntity Movie = MovieService.createMovie("deleteMovie");
	        Assert.assertEquals(beforeAdd + 1, MovieDao.count());
	        MovieEntity reqMovie = MovieDao.getOne(Movie.getId());
	        MovieService.deleteMovie(reqMovie.getId());
	        Assert.assertEquals(beforeAdd, MovieDao.count());
    @Test
	    public boolean isNowPlaying () {
	        MovieEntity Movie = MovieService.getOne("isNowPlaying ");
	        MovieEntity reqMovie = MovieDao.getOne(Movie.getId());
	        Assert.assertEquals(Movie.getId(), reqMovie.getId());
	    }
    @Test
	    public boolean isComingSoon () {
	        MovieEntity Movie = MovieService.createMovie("isComingSoon");
	        MovieEntity reqMovie = MovieDao.getOne(Movie.getId());
	        Assert.assertEquals(Movie.getId(), reqMovie.getId());
	    }
