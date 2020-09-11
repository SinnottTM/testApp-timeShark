/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tim.application.timeShark.model.Schedule;
import com.tim.application.timeShark.model.Shift;
import com.tim.application.timeShark.model.Staff;
import com.tim.application.timeShark.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    StaffService staffService;

    @Autowired
    ShiftService shiftService;

    @Autowired
    ScheduleService scheduleService;

    // Finding out staff rota (what shifts each staff are on)
    @GetMapping(value = "/staff/find")
    public StaffResource requestStaff(@RequestParam Integer id) {
        Staff staff = staffService.findStaff(id);
        return StaffFactory.fromModel(staff);
    }

    // Finding out shift rota (who is on each shift)
    @GetMapping(value = "/shift/find")
    public ScheduleResource requestShiftAll(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant shiftDate) {
        Schedule schedule = scheduleService.findScheduleByShift(shiftDate);
        return ScheduleFactory.fromModel(schedule);
    }

    // Finding out all shifts being covered by a particular staff
    @GetMapping(value = "/shift/findByStaff")
    public List<ShiftResource> findByStaff(@RequestParam Integer staffId) {
        List<Shift> shifts = shiftService.findByStaff(staffId);
        return ShiftFactory.fromModels(shifts);
    }

    // More easy to read version of the previous method, using JSON
    @GetMapping(value = "/shift/findByStaff/neat")
    public String findByStaffNeat(@RequestParam Integer staffId) {
        List<Shift> shifts = shiftService.findByStaff(staffId);

        ObjectMapper mapper = new ObjectMapper();
        String jsonShiftsNeat;
        try {
            jsonShiftsNeat = mapper.writeValueAsString(ShiftFactory.fromModels(shifts));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            jsonShiftsNeat = null;
        }
        return jsonShiftsNeat;
    }

    //
    @GetMapping(value = "/shift/NextWeek")
    public List<ShiftResource> findNextWeeksShiftsForStaff(@RequestParam Integer staffId) {
        List<Shift> shifts = shiftService.findNextWeeksShiftsForStaff(staffId);
        return ShiftFactory.fromModels(shifts);
    }

    //
    @GetMapping(value = "/shift/OneWeek")
    public List<ShiftResource> findAWeeksShiftsForStaff(@RequestParam Integer staffId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate) {

        //This is what a date looks like in a string.
        //Instant something = Instant.parse("2020-09-11T11:11:11.00Z");

        List<Shift> shifts = shiftService.findAWeeksShiftsForStaff(staffId, startDate);
        return ShiftFactory.fromModels(shifts);
    }


    //
    @GetMapping(value = "/schedule")
    public ScheduleResource scheduleOneWeek(@RequestParam Integer staffId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate) {
        Schedule schedule = scheduleService.findAWeeksScheduleForStaff(staffId, startDate);
        return ScheduleFactory.fromModel(schedule);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*

    // For returning all staff, need to link this to a getAll command and not a factory (or create get all in factory?)
    @GetMapping(value = "/shift/NextWeek/allStaff")
    Instant now = Instant.now();
    Instant nextWeek = Instant.now().plus(7, ChronoUnit.DAYS);
    List<ShiftEntity> shiftEntities = shiftRepository.findByShiftDateGreaterThanAndShiftDateLessThan(now, nextWeek);
        return ShiftFactory.fromEntities(shiftEntities);

    // Same as above, but using Hql Query rather than JPA automatically doing the query work
    @GetMapping(value = "/shift/hqlWeek")
    public List<ShiftResource> findAWeeksShiftsForStaffByHql(@RequestParam Integer staffId, @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) Instant startDate) {

        //This is what a date looks like in a string.
        //Instant something = Instant.parse("2020-09-11T11:11:11.00Z");

        List<Shift> shifts = shiftService.findAWeeksShiftsForStaffByHqlQuery(staffId, startDate);
        return ShiftFactory.fromModels(shifts);
    }

    // Same as above, but using Sql Query rather than JPA automatically doing the query work
    @GetMapping(value = "/shift/sqlWeek")
    public List<ShiftResource> findAWeeksShiftsForStaffBySql(@RequestParam Integer staffId, @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) Instant startDate) {

        //This is what a date looks like in a string.
        //Instant something = Instant.parse("2020-09-11T11:11:11.00Z");

        List<Shift> shifts = shiftService.findAWeeksShiftsForStaffBySqlQuery(staffId, startDate);
        return ShiftFactory.fromModels(shifts);
    }

     */

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}