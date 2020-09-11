/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

// Resource is same as Staff Model minus confidential information (to be added later).

public class StaffResource {


    private int id;
    private boolean management;
    private String name;
    private String contract;
    private int hours;


    /*

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // GENERAL RW

    // System rule to check if staff is management or not (unnecessary if SQL table noted manager or not?)

    public String isManagement() {
        if (management = true) {
            return "This staff member has management privileges";
        } else {
            return "This staff member does not have management privileges";
        }
    }

    */

}
