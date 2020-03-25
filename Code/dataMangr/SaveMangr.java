package Code.dataMangr;

import Code.menus.functions.ButtonFunc;
import Code.game.Handler;
import Code.game.Handler;
import Code.mapper.MapPlacer;
import Code.game.RoomID;
import Code.game.RoomID;
import Rooms.Room;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;


public class SaveMangr {
    
    private static Handler handler;
    private static Path file = Paths.get("SaveFile.csv");
    private Room room;
    private static int i=0;
    
    public SaveMangr(Handler handler){
        this.handler=handler;
        tryRead();
    }
    
    public SaveMangr(Room room){
        this.room=room;
    }
    
    private static String tryRead(){
        String text="null";
        try {
            reader(new BufferedReader(new FileReader("SaveFile.csv")));
        } catch (Exception ex) {
            System.out.println("Error, unable to find save file.");
            //create file
        }
        return text;
    }
    
    private static void reader(BufferedReader csvReader) throws Exception{
        String row;
        while (csvReader.readLine() != null){
            row=csvReader.readLine();
            String[] data = row.split(",");
            interpreter(data);
        }
        csvReader.close();
    }
    
    private static void interpreter(String[] data) throws Exception{
        RoomID Id=RoomID.valueOf(data[0]);
        Room room =RoomID.getRoom(Id,handler,false);
        ButtonFunc.saves[i]=(new SaveMangr(room));
        i++;
    }
    
    public static void newGame(int slot){
        String text="null";
        try {
            text=new String(Files.readAllBytes(file));
            text =text+ "\n" + RoomID.Room1+",null" ;
            Files.write(file, text.getBytes(), new OpenOption[0]);
            ButtonFunc.saves[slot]=(new SaveMangr(new Rooms.Room1(handler,true)));
        } catch (Exception ex) {
            System.out.println("Error, no se pudo crear el archivo de guardado.");
            ex.printStackTrace();
        }
    }
    
    public static void loadGame(SaveMangr save){
        MapPlacer.room.add(save.room);
        MapPlacer.room.get(MapPlacer.getRoom(save.room.getId())).placeRoom();
    }
    
    public static void saveGame(){
        String text="null";
        try {
            text=new String(Files.readAllBytes(file));
            text =text+ "\n" + getData();
            Files.write(file, text.getBytes(), new OpenOption[0]);
        } catch (Exception ex) {
            System.out.println("Error, unable to save game.");
        }
    }
    
    public static void eraseGame(SaveMangr save){
        
    }
    
    public static void copyGame(SaveMangr save,int slot){
        String text="null";
        try {
            text=new String(Files.readAllBytes(file));
            text =text+ "\n" + save.getData();
            Files.write(file, text.getBytes(), new OpenOption[0]);
            ButtonFunc.saves[3]=(new SaveMangr(RoomID.getRoom(save.room.getId(),handler,false)));
        } catch (Exception ex) {
            System.out.println("Error, no se pudo copiar el archivo de guardado.");
        }
    }
    
    public static String getData(){
        return MapPlacer.getRoomId().toString()+",null";
    }
    
    public String getDataString(){
        return this.room.getId().toString()+" all the other stuff";
    }
}