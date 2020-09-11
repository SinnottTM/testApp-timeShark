/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark.RW;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class RWStaffJavaToJasn {


    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        RWStaff rWStaff = new RWStaff();

        try {
            mapper.writeValue(new File("rWStaffTest.json"), rWStaff);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rWStaff);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static RWStaff newRWStaff() {
        RWStaff rWStaff = new RWStaff();

        rWStaff.setId(10);
        rWStaff.setManagement(false);
        rWStaff.setStaffName("James");
        rWStaff.setContract("Residential Carer");
        rWStaff.setHours(35);

        return rWStaff;
    }
}
