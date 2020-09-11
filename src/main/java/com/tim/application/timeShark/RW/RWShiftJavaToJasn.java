/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark.RW;

// RW Shift converted to Json

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.time.Instant;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RWShiftJavaToJasn {

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Jasn to Java Test
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        RWShift rWShift = new RWShift();

        try {
            mapper.writeValue(new File("rWShiftTest.json"), rWShift);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rWShift);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static RWShift newRWStaff() {
        RWShift rWShift = new RWShift();

        rWShift.setId(10);
        rWShift.setShifts("Monday");
        rWShift.setShiftDate(Instant.now());
        rWShift.setStaff_id(9);


        return rWShift;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

}
