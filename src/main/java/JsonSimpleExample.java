import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleExample {

    public static void main(String[] args) {


        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("/media/yashasvi/EAB0B071B0B0463B/Json/test.json"));

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            System.out.println(name);

         String  start= (String) jsonObject.get("start_date");
            System.out.println(start);

           String end= (String) jsonObject.get("end_date");
            System.out.println(end);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startdate = formatter.parse(start);
                Date enddate = formatter.parse(end);

                if(!startdate.before(enddate))
                {
                    System.out.println("Invalid");
                }
            }


            catch(java.text.ParseException e)
            {
                e.printStackTrace();
            }





//            // loop array
//            JSONArray msg = (JSONArray) jsonObject.get("messages");
//            Iterator<String> iterator = msg.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
          //  }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
//Parse the JSON String to date


}