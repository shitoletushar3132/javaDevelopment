import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoteApp {
    private static final String FILE_NAME="notes.txt";

    public static void main(String [] args) throws IOException{
        if(args.length < 1){
            System.out.println("Usage: java NoteApp [add/list/remove] [note or index]");
            return;
        }

        String command = args[0];

        switch (command){
            case "add":
                if (args.length<2){
                    System.out.println("Please Provide a note to add");
                    return;
                }
                String note = String.join(" ", Arrays.copyOfRange(args,1,args.length));
                addNote(note);
                break;

            case "list":
                listNotes();
                break;

            case "remove":
                if(args.length != 2){
                    System.out.println("Please provide the note number to remove");
                    break;
                }

                int indexToRemove;
                try{
                    indexToRemove = Integer.parseInt(args[1]);
                }catch (NumberFormatException e){
                    System.out.println("Invalid note number.");
                    return;
                }
                removeNote(indexToRemove);
                break;

            default:
                System.out.println("Unknow Command: "+command);
        }
    }

    private  static  void addNote(String note) throws  IOException{
        FileWriter writer = new FileWriter(FILE_NAME,true);

        writer.write(note + "\n");

        writer.close();

        System.out.println("✅ Note added.");

    }

    private static  void listNotes() throws IOException{
        File file = new File(FILE_NAME);
        if(!file.exists()){
            System.out.println("No notes Found");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        int count = 1;
        while ((line = reader.readLine()) != null){
            System.out.println(count+". "+line);
            count++;
        }
        reader.close();

    }

    private  static  void removeNote(int index) throws IOException{
        List<String> notes = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = reader.readLine()) != null) {
            notes.add(line);
        }
        reader.close();

        if(index < 1 || index > notes.size()){
            System.out.println("Invalid note number");
            notes.remove(index-1);
            FileWriter writer=new FileWriter(FILE_NAME);

            for(String note : notes){
                writer.write(note + '\n');
            }
            writer.close();
            System.out.println("Note removed");
        }
    }
}
