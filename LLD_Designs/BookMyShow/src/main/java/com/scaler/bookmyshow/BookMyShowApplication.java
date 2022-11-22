package com.scaler.bookmyshow;

import com.scaler.bookmyshow.controllers.*;
import com.scaler.bookmyshow.dto.CreateUserRequestDto;
import com.scaler.bookmyshow.dto.CreateUserResponseDto;
import com.scaler.bookmyshow.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {
    private UserController userController;
    private CityController cityController;
    private TheatreController theatreController;
    private TicketController ticketController;
    private AuditoriumController auditoriumController;
    private ActorController actorController;
    private MovieController movieController;
    private ShowController showController;

    @Autowired
    public BookMyShowApplication(UserController userController, CityController cityController,
                                 TheatreController theatreController, AuditoriumController auditoriumController,
                                 ActorController actorController, MovieController movieController,
                                 ShowController showController, TicketController ticketController) {
        this.userController = userController;
        this.cityController = cityController;
        this.theatreController = theatreController;
        this.auditoriumController = auditoriumController;
        this.actorController = actorController;
        this.movieController = movieController;
        this.showController = showController;
        this.ticketController = ticketController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create a user :->

//        CreateUserRequestDto requestDto = new CreateUserRequestDto();
//        requestDto.setEmail("2kayush.125@gmail.com");
//        CreateUserResponseDto responseDto = this.userController.createUser(requestDto);
//        System.out.println(responseDto.getUser());

        // create City :->

//        City city = this.cityController.addCity("Delhi");
//        System.out.println(city.getName());

        // create Theatre :->

//        Theatre theatre = this.theatreController.createTheatre("PVR", "Dab ri mod", 1L);
//        System.out.println(theatre);

        // create Auditorium :->

//        Auditorium auditorium = this.auditoriumController.createAudi("Audi1", 300, 1L);
        // add Seats :->
//        Map<SeatType, Integer> seatCount = new HashMap<>();
//        seatCount.put(SeatType.VIP, 20);
//        seatCount.put(SeatType.PLATINUM, 50);
//        seatCount.put(SeatType.GOLD, 80);
//        seatCount.put(SeatType.SILVER, 150);
//        auditoriumController.addSeats(1L, seatCount);

        // add actor :->

//        Actor actor = this.actorController.addActor("Elizabeth Olsen");
//        System.out.println(actor);

        // add movie :->

//        List<MovieFeature> movieFeatures = List.of(MovieFeature.THREE_D, MovieFeature.DOLBY);
//        List<Language> languages = List.of(Language.ENGLISH, Language.HINDI);
//        Movie movie = this.movieController.addMovie("Avenger", 120, 7.8, movieFeatures, languages, List.of(1L, 2L, 3L, 4L, 5L));
//        System.out.println(movie);

        // add show :->
//        Date date = new Date();
//        Language language = Language.ENGLISH;
//        Show show = showController.createShow(1L, 1L, date, date, language, null);
//        System.out.println(show);

//        create a ticket :-> (after this ticket creation returns success response then only the payment page will come up)..
//        ticketController.bookTicket(3L, List.of(4L, 2L, 3L), 1L);

        // creating ticket in a multithreaded environment :->
        TicketBookRunner ticketBookRunner1 = new TicketBookRunner(
                this.ticketController,
                3L,
                List.of(58L, 59L, 60L),
                1L
        );

        TicketBookRunner ticketBookRunner2 = new TicketBookRunner(
                this.ticketController,
                3L,
                List.of(60L, 61L, 62L),
                1L
        );

        Thread t1 = new Thread(ticketBookRunner1);
        Thread t2 = new Thread(ticketBookRunner2);
        t1.start();
        t2.start();
    }

}
