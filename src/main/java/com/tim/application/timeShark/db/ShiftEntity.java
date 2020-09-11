/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Table(name = "SHIFTS")
@Getter
@Setter
//@Builder - Not needed in this Class but added to show additional code that would be needed to run constructor below if builder used.
@Entity
public class ShiftEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "shifts")
    private String shifts;

    @Column(name = "shift_date")
    private Instant shiftDate;

    @Column(name = "staff_id")
    private Integer staffId;

    //Overloading is when you have the same method or constructor with different parameter signatures.

    // AllArgsVersion (@AllArgsConstructor) - For builder if needed
    public ShiftEntity(Integer id, String shifts, Instant shiftDate, Integer staffId) {
        this.id = id;
        this.shifts = shifts;
        this.shiftDate = shiftDate;
        this.staffId = staffId;
    }

    // NoArgsVersion (@NoArgsConstructor) - For construction of Entity objects using JPA.
    public ShiftEntity() {

    }

}