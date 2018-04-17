
package edu.csumb.xtreme.movieticketing;

import edu.csumb.xtreme.movieticketing.dao.AppUtils;
import edu.csumb.xtreme.movieticketing.dao.BookingDao;
import edu.csumb.xtreme.movieticketing.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("login", new User());
		return "login";
	}

	@PostMapping("/login")
	public boolean loginUser(@ModelAttribute User user) {
		boolean res = false;
		try {
			res =  AppUtils.autheticateUser(user.getUsername(), user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}


}
