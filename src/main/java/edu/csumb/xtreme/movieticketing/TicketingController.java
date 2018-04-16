package edu.csumb.xtreme.movieticketing;

import edu.csumb.xtreme.movieticketing.dao.BookingDao;
import edu.csumb.xtreme.movieticketing.dao.MovieDao;
import edu.csumb.xtreme.movieticketing.dao.MovieService;
import edu.csumb.xtreme.movieticketing.entities.MovieEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketingController {

    @Autowired
    MovieDao movieDao;

    @Autowired
    BookingDao bookingDao;

    @Autowired
    private MovieService movieService;


    @GetMapping("/greeting")
    public String greeting(
        @RequestParam(name = "name", required = false, defaultValue = "World") String name,
        Model model) {
        model.addAttribute("name", movieDao.findAll().get(0).getName());
        return "greeting";
    }

    @GetMapping("/list")
    public String home(Model model) {
        model.addAttribute("movies", movieDao.findAll());
        model.addAttribute("bookings", bookingDao.findAll());
        return "list";

    }

    @GetMapping("/index")
    public String index(Model model) {
        List<MovieEntity> nowPlaying = new ArrayList<>();
        List<MovieEntity> comingSoon = new ArrayList<>();;
        for(MovieEntity movie : movieDao.findAll()) {
            if(movieService.isNowPlaying(movie.getId())) {
                nowPlaying.add(movie);
            }
            if(movieService.isComingSoon(movie.getId())) {
                comingSoon.add(movie);
            }
        }
        model.addAttribute("nowPlaying", nowPlaying);
        model.addAttribute("comingSoon", comingSoon);
        return "index";
    }
}
