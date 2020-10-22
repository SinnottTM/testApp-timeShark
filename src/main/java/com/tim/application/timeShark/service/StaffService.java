/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark.service;

import com.tim.application.timeShark.db.StaffEntity;
import com.tim.application.timeShark.db.StaffRepository;
import com.tim.application.timeShark.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    // Using .get() to get the object from optional (Information Exists In Database).
    public Staff findStaff(Integer id) {
        StaffEntity staffEntity = staffRepository.findById(id).get();
        return StaffFactory.fromEntity(staffEntity);
    }

    // Setting up a method to get all listed staff information
    public List<StaffEntity> getAll() {
        return staffRepository.findAll();
    }

    public List<Staff> findStaffByIds(List<Integer> staffIds) {
        List<StaffEntity> staffEntities = staffRepository.findAllById(staffIds);
        return StaffFactory.fromEntities(staffEntities);
    }


    /*

    public Staff findStaffShift(Integer id) {
        StaffEntity staffEntity = staffRepository.findById(id).get();
        return StaffFactory.fromEntity(staffEntity);
    }

     */
}
