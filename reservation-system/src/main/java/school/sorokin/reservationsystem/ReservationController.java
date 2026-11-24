package school.sorokin.reservationsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public Reservation getReservationByID(
            @PathVariable("id") Long id
    ){

        System.out.println("Log Called Method");
        return reservationService.getReservationByID(id);
    }

    @GetMapping("/getALL")
    public List<Reservation> getAllReservations(){

        System.out.println("Log Called Method");
        return reservationService.findAllReservations();
    }
}
