package midterm2018;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jdk.nashorn.internal.parser.JSONParser;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        String question1and2 = "GET /add?a=3&b=4 HTTP/1.1\n"
            + "Host: localhost:1298\n"
            + "Connection: keep-alive\n"
            + "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36\n"
            + "Accept: image/webp,image/apng,image/*,*/*;q=0.8\n"
            + "Referer: http://localhost:1298/\n"
            + "Accept-Encoding: gzip, deflate, br\n"
            + "Accept-Language: en-US,en;q=0.9,es;q=0.8\n";

        String question3 = "{\n"
            + "    “task” : “inc”,\n"
            + "    “num” : 3\n"
            + "}\n";

        String question4and5 = "To opt out, you’ll need to enter the Settings menu by clicking the three vertical dots, all the way in the upper right corner of the browser. From there, you’ll need to enter the Advanced settings at the very bottom and find the “Allow Chrome sign in” toggle, then turn it to off. Doing so lets you sign into Google services like Gmail and Maps without signing into the Chrome browser itself.";


        System.out.println(question1and2);
        System.out.println(question3);
        System.out.println(question4and5);


        ////////////////////////////////////////////////////





        /////////////////////////////////////////////////////
        String[] words = question4and5.toLowerCase().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }

        Map<String, Integer> myMap = new HashMap<String, Integer>();

        for(int i = 0; i<words.length; i++){
            if(!myMap.containsKey(words[i])){
                myMap.put(words[i], 1);
            }
            else{
                myMap.put(words[i], myMap.get(words[i])+1);

            }
        }
        ///////////////////////////////////////////////////

        // print each answer at the end

        // Question 1
        // Return the Host  "Referer: http://localhost:1298/\n"
        System.out.println("QUESTION 1-------------------------------");
        String[] stuff = question1and2.split("\\r?\\n");
        for(String x: stuff){
            if (x.contains("Host:")){
                System.out.println(x);
            }
        }







        // Question 2
        // return sum of a and b   "GET /add?a=3&b=4 HTTP/1.1\n"  ans = 7
        // extract a and b from the string  string splitting then loop through to find a and b
        System.out.println("");
        System.out.println("");
        System.out.println("QUESTION 2-------------------------------");

        int a=0;
        int b=0;
        char t;
        String focus = null;
        for(String x: stuff){
            if (x.contains("a=")){
                focus = x;
            }
        }

        char[] chars = focus.toCharArray();
        for(int i=2; i<chars.length; i++){
            if(chars[i-1] == '='){
                if(chars[i-2] == 'a'){
                    a = Character.getNumericValue(chars[i]);
                }
                if(chars[i-2] == 'b'){
                    b = Character.getNumericValue(chars[i]);
                }

            }
        }
        int ans = a+b;
        System.out.println("a+b= "+ ans);










        // Question 3
        // convert to java object, increment num, convert back to json and return
        //add 1 to 3 and return 4
        System.out.println("");
        System.out.println("");
        System.out.println("QUESTION 3-------------------------------");

        //Gson gson = new Gson();
        //q3 user = gson.fromJson(question3, q3.class);
        //String abc = q3.getNum().getAsString();











        // Question 4
        // return unique words
        System.out.println("");
        System.out.println("");
        System.out.println("QUESTION 4-------------------------------");

        int count = 0;
        Iterator it = myMap.entrySet().iterator();
        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.print(entry.getKey() + ", ");
                count++;
            }
        }
        System.out.println("");
        System.out.println(count);










        // Question 5
        // return 2nd most common word
        System.out.println("");
        System.out.println("");
        System.out.println("QUESTION 5--------------------------------");

        ArrayList<Integer> myList = new ArrayList<Integer>();

        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            myList.add(entry.getValue());
        }

        Collections.sort(myList);
        Collections.reverse(myList);

        int secondhighest = myList.get(1);

        for (Map.Entry<String, Integer> e : myMap.entrySet()) {
            String key = e.getKey();
            int value = e.getValue();
            if(value == secondhighest){
                System.out.println(key);
            }
        }




    }



    public class q3{
        private String task;
        private String num;

        public String getTask(){
            return task;
        }
        public String getNum(){
            return num;
        }
        public void setNum(){
            this.num = num;
        }
    }
}
