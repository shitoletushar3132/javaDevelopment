package fileSystem;
import java.io.*;
import java.util.*;

public class MiniDB {
    static final String FILE_NAME = "users.txt";

    public static void addUser(User user) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
        bw.write(user.toCSV());
        bw.newLine();
        System.out.println("Add successfully");
        bw.close();
    }

    public static List<User> getAllUsers() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        List<User> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            User u = new User(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
            list.add(u);
        }
        br.close();
        return list;
    }

    public static User findById(int id) throws IOException {
        for (User u : getAllUsers()) {
            if (u.id == id) return u;
        }
        return null;
    }

    public static void deleteUserById(int idToDelete) throws IOException {
        List<User> users = getAllUsers();

        // Filter out the user to delete
        List<User> updatedUsers = new ArrayList<>();
        for (User user : users) {
            if (user.id != idToDelete) {
                updatedUsers.add(user);
            }
        }

        // Overwrite the original file with updated users
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, false)); // 'false' to overwrite
        for (User user : updatedUsers) {
            bw.write(user.toCSV());
            bw.newLine();
        }
        bw.close();

        System.out.println("User with id " + idToDelete + " deleted (if existed).");
    }

    public static void updateUserById(int idToUpdate, String newName, int newAge) throws IOException {
        List<User> users = getAllUsers();

        boolean found = false;
        for (User user : users) {
            if (user.id == idToUpdate) {
                user.name = newName;
                user.age = newAge;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("User with ID " + idToUpdate + " not found.");
            return;
        }

        // Overwrite the file with updated list
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, false));
        for (User user : users) {
            bw.write(user.toCSV());
            bw.newLine();
        }
        bw.close();

        System.out.println("User with ID " + idToUpdate + " updated successfully.");
    }



    public static  void main(String [] a){
        try{
            File file = new File(FILE_NAME);
            if(!file.exists()){
                file.createNewFile();
            }

//            User user1 = new User(1,"Tushar", 22);
//            addUser(user1);

            List<User> users ;

            users= getAllUsers();
            for(User u:users){
                System.out.println("ID: " + u.id + ", Name: " + u.name + ", Age: " + u.age);
            }

            deleteUserById(1);

            users =  getAllUsers();
            for(User u:users){
                System.out.println("ID: " + u.id + ", Name: " + u.name + ", Age: " + u.age);
            }

        } catch(IOException ex){
            System.out.println(ex);
        }
    }
}
