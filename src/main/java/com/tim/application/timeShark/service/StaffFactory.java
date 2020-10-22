/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark.service;

import com.tim.application.timeShark.StaffResource;
import com.tim.application.timeShark.db.ShiftEntity;
import com.tim.application.timeShark.db.StaffEntity;
import com.tim.application.timeShark.model.Shift;
import com.tim.application.timeShark.model.Staff;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StaffFactory {

    public static Staff fromEntity(StaffEntity staffEntity) {
        return Staff.builder()
                .id(staffEntity.getId())
                .management(staffEntity.getManagement())
                .name(staffEntity.getStaffName())
                .contract(staffEntity.getContract())
                .hours(staffEntity.getHours())
                .build();
    }

    public static List<Staff> fromEntities(List<StaffEntity> staffEntities) {
        List<Staff> staffs = new ArrayList<>();
        for (StaffEntity staffEntity : staffEntities) {
            Staff staff = fromEntity(staffEntity);
            staffs.add(staff);
        }
        return staffs;
    }

    public static StaffResource fromModel(Staff staff) {
        return StaffResource.builder()
                .id(staff.getId())
                .management(staff.getManagement())
                .name(staff.getName())
                .contract(staff.getContract())
                .hours(staff.getHours())
                .build();
    }

    public static List<StaffResource> fromModels(List<Staff> staffs) {
        List<StaffResource> staffResources = new ArrayList<>();
        for (Staff singleStaff: staffs) {
            StaffResource staffResource = fromModel(singleStaff);
            staffResources.add(staffResource);
        }
        return staffResources;
    }

     /*

    public Staff fromStaffInfoRequest(int id, boolean management, String name, String contract, int hours) {
        return Staff.builder()
                .id(id)
                .management(management)
                .name(name)
                .contract(contract)
                .hours(hours)
                .build();
    }

    */
}

