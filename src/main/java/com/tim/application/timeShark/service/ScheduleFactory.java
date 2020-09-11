/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */


package com.tim.application.timeShark.service;

import com.tim.application.timeShark.ScheduleResource;
import com.tim.application.timeShark.model.Schedule;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ScheduleFactory {

    // To return a single scheduleResource Entity object with all database parameters from both BB tables
    public static ScheduleResource fromModel(Schedule schedule) {
        // LocalDate localShiftDate = LocalDate.ofInstant(scheduleResource.getShiftDate(), ZoneId.systemDefault());
        // String dayOfTheWeekDisplayNameInEnglishShortHand = localShiftDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

        return ScheduleResource.builder()
                .staffResource(StaffFactory.fromModel(schedule.getStaff()))
                .shiftResources(ShiftFactory.fromModels(schedule.getShifts()))
                .build();
    }

    // To return a single scheduleResource Entity object with limited information from both tables using the ScheduleResource class
    public static ScheduleResource fromModelLimited(Schedule schedule) {
        return ScheduleResource.builder()
                .staffResource(StaffFactory.fromModel(schedule.getStaff()))
                .build();
    }

    // To return multiple scheduleResource Entities via ArrayList using the ScheduleResource class
    public static List<ScheduleResource> fromModels(List<Schedule> schedules) {
        List<ScheduleResource> scheduleResources = new ArrayList<>();
        for (Schedule schedule : schedules) {
            ScheduleResource scheduleResource = fromModel(schedule);
            scheduleResources.add(scheduleResource);
        }
        return scheduleResources;
    }

}

