/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark.RW;

import java.time.Instant;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RW {

    // Method for formatting current time to DD/MM/YY & HH/MM/SS format.
    public void timeFormatter() {

        // Getting current time using Instant.
        Instant todayTime = Instant.now();

        // Formatter for taking a date and standardising it to UK time formatting, checking my computers timezone and shortening date.
        DateTimeFormatter formatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                        .withLocale(Locale.UK)
                        .withZone(ZoneId.systemDefault());

        // Taking all the above and returning a string that can be called as needed.
        String output = formatter.format(todayTime);

        /*
        NOTE: THIS IS AN EXAMPLE USING DATE, DO NOT USE DATE! USE INSTANCE!
        Date todayDate = Date.from(todayTime);
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        String todayFormattedDate = formatter.format(todayDate);
         */


    }

    //-----------------------------------------------------------------------------------------------------------------

    // Enum for listing days of the week, starting from Monday & ending on sunday
    public enum Days {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
    }

    //-----------------------------------------------------------------------------------------------------------------

    // Setting up shift patterns.
    public enum Shifts {
        early, late, night, off
    }

    //-----------------------------------------------------------------------------------------------------------------

    // Function for getting month of the year.
    public class MonthOfYear {
        public void main(String[] args) {
            Month month = Month.from(Instant.now());
            System.out.println("The current month is: " + month);
        }
    }

    //-----------------------------------------------------------------------------------------------------------------

    // Function for getting days of current month in the year, using length method. Might be useful for calendar.
    public class DaysInMonth {
        public void main(String[] args) {
            Month month = Month.from(Instant.now());
            System.out.println("Total Number of days: " + month.length(true));
        }
    }

    //-----------------------------------------------------------------------------------------------------------------

    //Since I can't interact with the Database due to some new Intella-J issue... Gr... A ListArray of the staff instead.
    public class StaffArrayList {
        public void main(String[] args) {

            ArrayList<String> staffArrayList = new ArrayList<String>();

            staffArrayList.add(1, "Glenn");
            staffArrayList.add(2, "Tim");
            staffArrayList.add(3, "Ray");
            staffArrayList.add(4, "Gordon");
            staffArrayList.add(5, "Leila");
            staffArrayList.add(6, "Mo");
            staffArrayList.add(7, "Brenda");
            staffArrayList.add(8, "Trish");
            staffArrayList.add(9, "Kenny");

            //removing Kenny as he was not in initial Database using index number.
            staffArrayList.remove(8);

            //removing Trish as she was not in initial Database using object name.
            staffArrayList.remove("Trish");

            //To view StaffArrayList
            System.out.println(staffArrayList);

            //Creating a copy to view (I imagine this as a separation of Database from user). Using var.
            var finalStaffList = List.copyOf(staffArrayList);
            System.out.println(finalStaffList);

        }
    }

    //-----------------------------------------------------------------------------------------------------------------

    //Setting up constructor for declaring work time. Realised this won't transfer across.
    public class WorkingTime {

        private final int startHour;
        private final int endHour;

        public WorkingTime(int startHour, int endHour) {
            this.startHour = startHour;
            this.endHour = endHour;
        }

    }

    //-----------------------------------------------------------------------------------------------------------------

    /*
    public class RWJavaToJasnExample {

    /*
    PERSON CLASS

    import java.util.List;
import java.util.Map;

public class Person {

    String name;
    Integer age;
    List<String> hobbies;
    Map<String, String> languages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }
}

     */

    /*

    POM FILE DEPENDENCY

    <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.10.2</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.10.2</version>
</dependency>

     */

    /*

    CONVERTING JAVA OBJECT TO JASN

    import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertJavaObjectToJson {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Person person = newPerson();

        try {
            mapper.writeValue(new File("person.json"), person);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Person newPerson() {
        Person person = new Person();

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Football");
        hobbies.add("Cooking");
        hobbies.add("Swimming");

        Map<String, String> languages = new HashMap<>();
        languages.put("French", "Beginner");
        languages.put("German", "Intermediate");
        languages.put("Spanish", "Advanced");

        person.setName("David");
        person.setAge(30);
        person.setHobbies(hobbies);
        person.setLanguages(languages);

        return person;
    }
}

     */

    /*

    OUTPUT

    {
  "name" : "David",
  "age" : 30,
  "hobbies" : [ "Football", "Cooking", "Swimming" ],
  "languages" : {
    "French" : "Beginner",
    "German" : "Intermediate",
    "Spanish" : "Advanced"
  }
}

    NOTE: Also a file person.json is created in the project workspace.
     */
}


