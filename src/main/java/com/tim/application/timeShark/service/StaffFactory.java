/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark.service;

import com.tim.application.timeShark.db.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StaffFactory {

    @Autowired
    StaffRepository staffRepository;

    /*

    public StaffEntity fromModel(Staff staff) {
        return StaffEntity.builder()
                .id(staff.getId())
                .management(staff.isManagement())
                .name(staff.getName())
                .contract(staff.getContract())
                .hours(staff.getHours())
                .build();
    }

    public Staff fromStaffInfoRequest(int id, boolean management, String name, String contract, int hours) {
        return Staff.builder()
                .id(id)
                .management(management)
                .name(name)
                .contract(contract)
                .hours(hours)
                .build();

    }

    public Staff fromEntity(StaffEntity staffEntity) {
        return Staff.builder()
                .id(StaffEntity.getId())
                .management(StaffEntity.getManagement())
                .name(StaffEntity.getName())
                .contract(StaffEntity.getContract())
                .hours(StaffEntity.getHours())
                .build();

    }

    */

}

