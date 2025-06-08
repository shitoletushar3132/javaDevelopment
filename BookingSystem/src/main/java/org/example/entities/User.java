package org.example.entities;

import java.util.List;

public class User {
    private String name;
    private String password;
    private String hashPassword;
    private List<Ticket> ticketsBooked;
    private String userId;

    public User(String name, String password,String hashPassword, List<Ticket> ticketsBooked, String userId){
        this.name = name;
        this.password=password;
        this.hashPassword=hashPassword;
        this.ticketsBooked=ticketsBooked;
        this.userId = userId;
    }

    public User(){}

    public  String getName(){
        return this.name;
    }

    public  String getPassword(){
        return  this.password;
    }

    public  String getHashPassword(){
        return  this.hashPassword;
    }

    public  List<Ticket> getticketsBooked(){
        return this.ticketsBooked;
    }

    public void printTickets(){
        for(int i=0; i<ticketsBooked.size(); i++){
            System.out.println(ticketsBooked.get(i).getTicketInfo());
        }
    }


    public String getUserId(){
        return userId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getHashedPassword(){
        return this.hashPassword;
    }

    public void setTicketsBooked(Ticket ticketsBooked) {
        this.ticketsBooked.add(ticketsBooked);
    }

    public void setHashedPassword(String hashPassword){
        this.hashPassword = hashPassword;
    }


}
