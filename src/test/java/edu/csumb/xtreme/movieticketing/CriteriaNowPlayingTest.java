package edu.csumb.xtreme.movieticketing;

import edu.csumb.xtreme.movieticketing.dao.MovieDao;
import edu.csumb.xtreme.movieticketing.entities.MovieEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import edu.csumb.xtreme.movieticketing.criterias.Criteria;
import edu.csumb.xtreme.movieticketing.criterias.CriteriaNowPlaying;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CriteriaNowPlayingTest {
    
    @Autowired
    MovieDao movieDao;
    
    @Test
    public void testNowPlaying() throws Exception {
        List<MovieEntity> movies = new ArrayList<MovieEntity>();
        
        for(MovieEntity movie : movieDao.findAll()) {
          movies.add(movie);
        }
        
        Criteria nowPlaying = new CriteriaNowPlaying();
        
        System.out.println(nowPlaying);
    }

}