package DayPlanner;

import com.google.gson.Gson;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FileHandler {

    public void writeToFile(HashMap<LocalDateTime, Event> events) throws IOException {

        Gson gson=new Gson();

          BufferedWriter bw=new BufferedWriter(new FileWriter(new File("events.json")));
              for (Map.Entry<LocalDateTime, Event> event : events.entrySet()) {
                  String jsonLine = gson.toJson(event.getValue()) + "\n";
                  bw.write(jsonLine);

              }
              bw.close();
          }


    public HashMap<LocalDateTime, Event> readFromFile() throws IOException {

        HashMap<LocalDateTime,Event> map=new HashMap<LocalDateTime,Event>();
        Gson gson=new Gson();

        BufferedReader br=new BufferedReader(new FileReader(new File("events.json")));
        String jsonLine;
        while ((jsonLine=br.readLine())!=null){
            Event event=gson.fromJson(jsonLine,Event.class);
            map.put(event.getDate(),event);
        }
        br.close();

        return map;
    }
}


