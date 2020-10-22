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
import com.tim.application.timeShark.model.ShiftSchedule;
import com.tim.application.timeShark.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

    // Set up method that takes parameter instant (shiftDate).
    public ShiftSchedule findScheduleByShift(Instant shiftDate) {
        //use shiftDate to generate a shift object.
        List<Shift> shifts = shiftService.findShiftsByShiftDate(shiftDate);
        //iterate through staff with shared shiftDate as the shift object above.
        List<Integer> staffIds = new ArrayList<>();
        for (Shift shift : shifts) {
            staffIds.add(shift.getStaffId());
        }
        //return schedule object (which is itself an object made of two list objects but NOT itself a list) for the given date.
        List<Staff> staff = staffService.findStaffByIds(staffIds);
        return ShiftSchedule.builder().staff(staff).shift(shifts.get(0)).build();
    }
}
