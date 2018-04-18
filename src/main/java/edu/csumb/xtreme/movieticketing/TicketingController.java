package edu.csumb.xtreme.movieticketing;

import edu.csumb.xtreme.movieticketing.dao.BookingDao;
import edu.csumb.xtreme.movieticketing.dao.MovieDao;

import edu.csumb.xtreme.movieticketing.entities.MovieEntity;
import java.util.ArrayList;
import java.util.List;
import edu.csumb.xtreme.movieticketing.criterias.Criteria;
import edu.csumb.xtreme.movieticketing.criterias.CriteriaNowPlaying;
import edu.csumb.xtreme.movieticketing.criterias.CriteriaComingSoon;
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
        List<MovieEntity> movies = new ArrayList<>();
        for(MovieEntity movie : movieDao.findAll()) {
            movies.add(movie);
        }
        Criteria nowPlaying = new CriteriaNowPlaying();
        Criteria comingSoon = new CriteriaComingSoon();
        model.addAttribute("nowPlaying", nowPlaying.meetCriteria(movies));
        model.addAttribute("comingSoon", comingSoon.meetCriteria(movies));
        return "index";
    }
}
