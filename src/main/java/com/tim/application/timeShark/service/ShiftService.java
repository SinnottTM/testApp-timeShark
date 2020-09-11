/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark.service;

import com.tim.application.timeShark.db.ShiftEntity;
import com.tim.application.timeShark.db.ShiftRepository;
import com.tim.application.timeShark.model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ShiftService {

    @Autowired
    ShiftRepository shiftRepository;


    // To return single shift entity in DB using .get() to get the object from optional (Information Exists In Database).
    public Shift findShift(Integer id) {
        ShiftEntity shiftEntity = shiftRepository.findById(id).get();
        return ShiftFactory.fromEntity(shiftEntity);
    }



    // To return list of all shifts entities in DB
    public Shift findShiftAllStaffNames(Integer id) {
        ShiftEntity shiftEntity = shiftRepository.findById(id).get();
        return ShiftFactory.fromEntity(shiftEntity);
    }

    // Setting up a method to get all listed shift information
    public List<ShiftEntity> getAll() {
        return shiftRepository.findAll();
    }

    //
    public List<Shift> findByStaff(Integer staffId) {
        List<ShiftEntity> shiftEntities = shiftRepository.findByStaffId(staffId);
        return ShiftFactory.fromEntities(shiftEntities);
    }

    //
    public List<Shift> findNextWeeksShiftsForStaff(Integer staffId) {
        Instant now = Instant.now();
        Instant nextWeek = Instant.now().plus(7, ChronoUnit.DAYS);
        List<ShiftEntity> shiftEntities = shiftRepository.findByStaffIdAndShiftDateGreaterThanAndShiftDateLessThan(staffId, now, nextWeek);
        return ShiftFactory.fromEntities(shiftEntities);
    }

    //
    public List<Shift> findAWeeksShiftsForStaff(Integer staffId, Instant startDate) {
        Instant sevenDaysLater = startDate.plus(7, ChronoUnit.DAYS);
        List<ShiftEntity> shiftEntities = shiftRepository.findByStaffIdAndShiftDateGreaterThanAndShiftDateLessThan(staffId, startDate, sevenDaysLater);
        return ShiftFactory.fromEntities(shiftEntities);
    }

    /*

    // Same as above, but using Hql Query rather than JPA automatically doing the query work
    public List<Shift> findAWeeksShiftsForStaffByHqlQuery(Integer staffId, Instant startDate) {
        Instant sevenDaysLater = startDate.plus(7, ChronoUnit.DAYS);
        List<ShiftEntity> shiftEntities = shiftRepository.findAWeeksShiftsForStaffByHqlQuery(staffId, startDate, sevenDaysLater);
        return ShiftFactory.fromEntities(shiftEntities);
    }

    // Same as above, but using Sql Query rather than JPA automatically doing the query work
    public List<Shift> findAWeeksShiftsForStaffBySqlQuery(Integer staffId, Instant startDate) {
        Instant sevenDaysLater = startDate.plus(7, ChronoUnit.DAYS);
        List<ShiftEntity> shiftEntities = shiftRepository.findAWeeksShiftsForStaffBySqlQuery(staffId, startDate, sevenDaysLater);
        return ShiftFactory.fromEntities(shiftEntities);
    }

     */

}
