
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class User {

    String name;
    Long age, sex;
    int id;
    Long[] rating = new Long[25];

    public User() {
        name = null;
        sex = 0L;
        age = 0L;
        for (int i = 0; i < 25; i++) {
            rating[i] = 0L;
        }
    }

    static User[] user = new User[50];

    static JSONParser parser = new JSONParser();

    static {

        for (int i = 0; i < 50; i++) {
            user[i] = new User();
        }
        try {

            JSONObject jObject = (JSONObject) parser.parse(
                    new FileReader("user_data_gaa.json"));
            JSONArray userList = (JSONArray) jObject.get("users");
            Iterator<JSONObject> iterator = userList.iterator();

            int i = 0;

            while (iterator.hasNext() && i < 50) {
                JSONObject jObject1 = iterator.next();
                user[i].name = (String) jObject1.get("name");
                user[i].id = i;
                user[i].age = (Long) jObject1.get("age");
                user[i].sex = (Long) jObject1.get("sex");
                user[i].rating[0] = (Long) jObject1.get("rating__r0");
                user[i].rating[1] = (Long) jObject1.get("rating__r1");
                user[i].rating[2] = (Long) jObject1.get("rating__r2");
                user[i].rating[3] = (Long) jObject1.get("rating__r3");
                user[i].rating[4] = (Long) jObject1.get("rating__r4");
                user[i].rating[5] = (Long) jObject1.get("rating__r5");
                user[i].rating[6] = (Long) jObject1.get("rating__r6");
                user[i].rating[7] = (Long) jObject1.get("rating__r7");
                user[i].rating[8] = (Long) jObject1.get("rating__r8");
                user[i].rating[9] = (Long) jObject1.get("rating__r9");
                user[i].rating[10] = (Long) jObject1.get("rating__r10");
                user[i].rating[11] = (Long) jObject1.get("rating__r11");
                user[i].rating[12] = (Long) jObject1.get("rating__r12");
                user[i].rating[13] = (Long) jObject1.get("rating__r13");
                user[i].rating[14] = (Long) jObject1.get("rating__r14");
                user[i].rating[15] = (Long) jObject1.get("rating__r15");
                user[i].rating[16] = (Long) jObject1.get("rating__r16");
                user[i].rating[17] = (Long) jObject1.get("rating__r17");
                user[i].rating[18] = (Long) jObject1.get("rating__r18");
                user[i].rating[19] = (Long) jObject1.get("rating__r19");
                user[i].rating[20] = (Long) jObject1.get("rating__r20");
                user[i].rating[21] = (Long) jObject1.get("rating__r21");
                user[i].rating[22] = (Long) jObject1.get("rating__r22");
                user[i].rating[23] = (Long) jObject1.get("rating__r23");
                user[i].rating[24] = (Long) jObject1.get("rating__r24");
                i++;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static float getMaxAge() {

        Long maxAge = Long.MIN_VALUE;
        for (int i = 0; i < 50; i++) {
            if (maxAge < user[i].age) {
                maxAge = user[i].age;
            }
        }
        return (float) maxAge;
    }

    public static User[] getUsers() {
        User[] retUsers = user.clone();
        return retUsers;
    }

    public static User findById(int id) {

        int temp = 0;
        for (int i = 0; i < 50; i++) {
            if (user[i].id == id) {
                temp = i;
                break;
            }
        }
        return user[temp];
    }
}
