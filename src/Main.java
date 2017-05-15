import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by Vitalii on 15.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        JsonObject json = new JsonObject();
        json.addProperty("name","Jon Doe");
        json.addProperty("age", 35);
        System.out.println(json.toString());

        Person person = new Gson().fromJson(json,Person.class);
        System.out.println("Name " + person.getName() + " Age"+person.getAge());

        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < 3; i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name","Jon Doe"+i);
            jsonObject.addProperty("age", 35+i);
            jsonArray.add(jsonObject);
        }

        System.out.println(jsonArray);

        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("first", json.toString());
        jsonObject2.add("data",jsonArray);
        System.out.println(jsonObject2.toString());

        ArrayList<Person> list = new Gson().fromJson(jsonArray,new TypeToken<ArrayList<Person>>(){}.getType());

        for (Person person1 : list) {
            System.out.println("Name " + person1.getName() + " Age"+person1.getAge());
            System.out.println(new Gson().toJson(person1));
        }
    }

    private class Person{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
