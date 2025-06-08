package org.example;

import org.example.entities.Train;
import org.example.entities.User;
import org.example.services.UserBookingService;
import org.example.util.UserServiceUtil;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Running Train Booking System");

        Scanner sc = new Scanner(System.in);

        int option = 0;

        UserBookingService userBookingService;

        Train trainSelectedForBooking = new Train();


        try{
            userBookingService = new UserBookingService();
        } catch (IOException ex){
            System.out.println("There is something wrong"+ ex);
            return;
        }

        while(option!=7){
            System.out.println("Choose Option");
            System.out.println("1. Sign up");
            System.out.println("2. Login");
            System.out.println("3. Fetch Bookings");
            System.out.println("4. search Trains");
            System.out.println("5. Book a Seat");
            System.out.println("6. Cancel my Booking");
            System.out.println("7. Exit the App");

            option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("Enter the username to signup");
                    String nameToSignUp = sc.next();
                    System.out.println("Enter the password to signup");
                    String passwordToSignUp=sc.next();
                    User userToSignup = new User(nameToSignUp,passwordToSignUp, UserServiceUtil.hashPassword(passwordToSignUp),new ArrayList<>(), UUID.randomUUID().toString());
                    userBookingService.signUp(userToSignup);
                    break;
                case 2:
                    System.out.println("Enter the username to Login");
                    String nameToLogin = sc.next();
                    System.out.println("Enter the password to Login");
                    String passwordToLogin=sc.next();
                    User userToLogin = new User(nameToLogin,passwordToLogin, UserServiceUtil.hashPassword(passwordToLogin),new ArrayList<>(), UUID.randomUUID().toString());

                    try{
                        userBookingService = new UserBookingService(userToLogin);
                    }catch (IOException ex){
                        System.out.println(ex);
                        return ;
                    }
                    break;
                case 3:
                    System.out.println("Fetching your bookings");
                    userBookingService.fetchBooking();
                    break;

                case 4:
                    System.out.println("Type your Source Station");
                    String source = sc.next();

                    System.out.println("Type your destination station");
                    String dest = sc.next();
                    List<Train> trains = userBookingService.getTrains(source,dest);

                    if (trains.isEmpty()) {
                        System.out.println("No trains found for this route.");
                        break;
                    }

                    int index =1;

                    for(Train t:trains){
                        System.out.println(index+ ". Train Id : "+ t.getTrainId());
                        for(Map.Entry<String,String> entry: t.getStationTimes().entrySet()){
                            System.out.println("station: "+ entry.getKey()+" , time: "+entry.getValue());
                        }
                        index++;
                    }
                    System.out.println("Select a train by typing 1,2,3...");
                    int trainChoice = sc.nextInt();
                    sc.nextLine(); // consume newline

                    if (trainChoice > 0 && trainChoice <= trains.size()) {
                        trainSelectedForBooking = trains.get(trainChoice - 1);  // zero-based index
                        System.out.println("Train " + trainSelectedForBooking.getTrainId() + " selected.");
                    } else {
                        System.out.println("Invalid train selection.");
                    }
                    break;
                case 5:
                    if (trainSelectedForBooking.getTrainId() == null) {
                        System.out.println("No train selected. Please search and select a train first.");
                        break;
                    }
                    System.out.println("Available seats (0 = free, 1 = booked):");
                    List<List<Integer>> seats = userBookingService.fetchSeats(trainSelectedForBooking);
                    for (List<Integer> row : seats) {
                        for (Integer val : row) {
                            System.out.print(val + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("Select the seat by typing the row and column");
                    System.out.println("Enter the row");
                    int row = sc.nextInt();
                    System.out.println("Enter the column");
                    int col = sc.nextInt();
                    System.out.println("Booking your seat....");
                    Boolean booked = userBookingService.bookTicket(trainSelectedForBooking, row, col,"hello","hello2");
                    if(booked.equals(Boolean.TRUE)){
                        System.out.println("Booked! Enjoy your journey");
                    }else{
                        System.out.println("Can't book this seat");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}