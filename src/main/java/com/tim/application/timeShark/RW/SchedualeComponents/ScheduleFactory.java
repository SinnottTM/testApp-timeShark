/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/*
package com.tim.application.timeShark.service;

import com.tim.application.timeShark.ScheduleService;
import com.tim.application.timeShark.ScheduleResource;
import com.tim.application.timeShark.ShiftResource;
import com.tim.application.timeShark.db.ScheduleEntity;
import com.tim.application.timeShark.db.ShiftEntity;
import com.tim.application.timeShark.model.Shift;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFactory {

    public static ScheduleService fromEntity(ScheduleEntity scheduleEntity) {
        return ScheduleService.builder()
                .id(scheduleEntity.getId())
                .shifts(scheduleEntity.getShifts())
                .shiftDate(scheduleEntity.getShiftDate())
                .staffId(scheduleEntity.getStaffId())
                .build();
    }

    // To return single objects, this fromModel method works fine
    public static ScheduleResource fromModel(ScheduleService schedule) {
        return ScheduleResource.builder()
                .id(schedule.getId())
                .shifts(schedule.getShifts())
                .shiftDate(schedule.getShiftDate())
                .staffId(schedule.getStaffId())
                .build();
    }

    // To return multiple objects, we utilise a list with our fromModels method.
    public static List<ScheduleResource> fromModels(List<ScheduleService> schedules) {
        List<ShiftResource> shiftResources = new ArrayList<>();
        for (ScheduleService schedule : schedules) {
            ScheduleResource scheduleResource = fromModel(schedule);
            scheduleResource.add(scheduleResource);
        }
        return shiftResources;
    }


    // To return multiple Shift Entities in a list called shifts.
    public static List<Shift> fromEntities(List<ShiftEntity> shiftEntities) {
        List<Shift> shifts = new ArrayList<>();
        for (ShiftEntity shiftEntity : shiftEntities) {
            Shift shift = fromEntity(shiftEntity);
            shifts.add(shift);
        }
        return shifts;
    }
}

 */
