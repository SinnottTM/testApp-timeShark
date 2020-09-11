/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark.service;


import com.tim.application.timeShark.model.Schedule;
import com.tim.application.timeShark.model.Shift;
import com.tim.application.timeShark.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    StaffService staffService;

    @Autowired
    ShiftService shiftService;

    public Schedule findAWeeksScheduleForStaff(Integer staffId, Instant startDate) {
        Staff staff = staffService.findStaff(staffId);
        List<Shift> shifts = shiftService.findAWeeksShiftsForStaff(staffId, startDate);
        return Schedule.builder().staff(staff).shifts(shifts).build();
    }

    // HOMEWORK 24/9/2020 - Return all staff on particular date

    public Schedule findScheduleByShift(Instant shiftDate) {
        List<Shift> shifts = shiftService.findShift(shiftDate);

    }
}
