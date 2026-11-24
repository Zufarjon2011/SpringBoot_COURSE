package school.sorokin.reservationsystem;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ReservationService {

    Random random = new Random();

    private final Map<Long , Reservation> reservationMap = Map.of(
            1L, new Reservation(
                    1L,
                    100L,
                    40L,
                    LocalDate.now(),
                    LocalDate.now().plusDays(6),
                    ReservationStatus.APPROVED
            ),
            2L, new Reservation(
                    2L,
                    102L,
                    34L,
                    LocalDate.now(),
                    LocalDate.now().plusDays(random.nextInt(3)),
                    ReservationStatus.APPROVED
            ),
            3L, new Reservation(
                    3L,
                    345L,
                    11L,
                    LocalDate.now(),
                    LocalDate.now().plusDays(random.nextInt(5)),
                    ReservationStatus.APPROVED
            )
    );


    public Reservation getReservationByID(
            Long id
    ) {
        if(!reservationMap.containsKey(id)){
            throw new NoSuchElementException("Not Found!");
        }
        else{
            return reservationMap.get(id);
        }
    }

    public List<Reservation> findAllReservations() {
        return reservationMap.values().stream().toList();
    }
}
