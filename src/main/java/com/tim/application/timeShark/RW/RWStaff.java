/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark.RW;

// Note: Included getters and setters (Didn't write out get & set methods).

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RWStaff {

    private Integer id;
    private Boolean management;
    private String staffName;
    private String contract;
    private Integer hours;

}
