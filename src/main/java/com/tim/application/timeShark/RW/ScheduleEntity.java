/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
/*

package com.tim.application.timeShark.RW;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

// Note: This solution didn't work as it was not one to one (staff to shift) but it might be good to refer to down the line

@Getter
@Setter
@Builder
@Entity
// I used a secondary table function to combine two tables within the database into one entity for the sake of presenting data etc.
@Table(name = "SHIFTS")
@SecondaryTable(name = "STAFF", pkJoinColumns = @PrimaryKeyJoinColumn(name = "staff_id"))

// Setting up
// entity object that takes its parameters from both of the DB tables
public class ScheduleEntity {
    /*

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "shiftType")
    private String shift_type;

    @Column(name = "shift_date")
    private Instant shiftDate;

    @Column(name = "staff_id")
    private Integer staffId;

    //I can't reuse column names even if they are explicitly stated to occur in different tables? Annoying.

    @Column(name = "id", table = "STAFF")
    private Integer id;

    @Column(name = "management", table = "STAFF")
    private Boolean management;

    @Column(name = "name", table = "STAFF")
    private String staffName;

    @Column(name = "contract", table = "STAFF")
    private String contract;

    @Column(name = "hours", table = "STAFF")
    private Integer hours;

}

 */

