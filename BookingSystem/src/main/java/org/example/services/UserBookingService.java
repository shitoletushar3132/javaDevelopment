package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Ticket;
import org.example.entities.Train;
import org.example.entities.User;
import org.example.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UserBookingService {

    private List<User> userList;

    private User user;

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final String USERS_PATH="src/main/java/org/example/localDb/users.json";

    public UserBookingService() throws IOException{
        File users = new File(USERS_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }

    public UserBookingService(User user )throws IOException {
        this.user=user;
        File users = new File(USERS_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }

    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1->{ return  user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getPassword());}).findFirst();
        return foundUser.isPresent();
    }

    public boolean signUp(User user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return  Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws  IOException{
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile,userList);
    }


    public void fetchBooking(){

        if (user == null || user.getUserId() == null) {
            System.out.println("User not logged in. Please login first.");
            return;
        }

        Optional<User> userFetched = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();

        if(userFetched.isPresent()){
            userFetched.get().printTickets();
        }
    }


    public List<Train> getTrains(String source, String destination){
        try{
            TrainService trainService = new TrainService();
            return trainService.searchTrains(source, destination);
        }catch(IOException ex){
            return new ArrayList<>();
        }
    }

    public List<List<Integer>> fetchSeats(Train train){
        return train.getSeats();
    }

    public Boolean bookTicket(Train train, int row, int seat, String source, String destination) {
        if (user == null || user.getUserId() == null) {
            System.out.println("Login first!");
            return false;
        }

        try {
            TrainService trainService = new TrainService();
            List<List<Integer>> seats = train.getSeats();

            if (row >= 0 && row < seats.size() && seat >= 0 && seat < seats.get(row).size()) {
                if (seats.get(row).get(seat) == 0) {
                    // Book the seat
                    seats.get(row).set(seat, 1);
                    train.setSeats(seats);

                    // Update train
                    trainService.addTrain(train);

                    // Create a ticket
                    Ticket newTicket = new Ticket(
                            String.valueOf(row * seat),
                            user.getUserId(),
                            source,
                            destination,
                            new Date(),
                            train
                    );

                    // Add ticket to user
                    user.getticketsBooked().add(newTicket);

                    // Save user list to file
                    saveUserListToFile();

                    return true;
                } else {
                    System.out.println("Seat already booked.");
                    return false;
                }
            } else {
                System.out.println("Invalid row or seat.");
                return false;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
