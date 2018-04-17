package edu.csumb.xtreme.movieticketing.dao;

import edu.csumb.xtreme.movieticketing.entities.BookingEntity;
import edu.csumb.xtreme.movieticketing.entities.ViewerEntity;
import edu.csumb.xtreme.movieticketing.entities.ViewerEntity.ViewerEntityBuilder;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ViewerService {

    @Autowired
    private ViewerDao viewerDao;

    @Qualifier("bookingDao")
    @Autowired
    private BookingDao bookingDao;


    public ViewerEntity createViewer(String username) {
        ViewerEntityBuilder builder = ViewerEntityBuilder.aViewerEntity();
        builder.withUsername(username);
        return viewerDao.save(builder.build());
    }
    
    public Optional<ViewerEntity> findViewer(int id){
        return viewerDao.findById(id);
    }


    public void deleteViewer(int viewerId) {
        viewerDao.deleteById(viewerId);
    }

    public List<BookingEntity> getBookings(int viewerId) {
        List<BookingEntity> viewerBookings = new ArrayList<>();
        for (BookingEntity bookingEntity : bookingDao.findAll()) {
            if (bookingEntity.getViewer().getId() == viewerId) {
                viewerBookings.add(bookingEntity);
            }
        }
        return viewerBookings;
    }
}
