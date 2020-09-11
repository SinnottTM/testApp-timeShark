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

public class RWShiftJavaToJasn {

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
}
