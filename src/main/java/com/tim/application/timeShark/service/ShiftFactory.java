/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark.service;

import com.tim.application.timeShark.ShiftResource;
import com.tim.application.timeShark.db.ShiftEntity;
import com.tim.application.timeShark.model.Shift;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShiftFactory {

    public static Shift fromEntity(ShiftEntity shiftEntity) {
        return Shift.builder()
                .id(shiftEntity.getId())
                .shifts(shiftEntity.getShifts())
                .shiftDate(shiftEntity.getShiftDate())
                .staffId(shiftEntity.getStaffId())
                .build();
    }

    // To return single objects, this fromModel method works fine
    public static ShiftResource fromModel(Shift shift) {
        return ShiftResource.builder()
                .id(shift.getId())
                .shifts(shift.getShifts())
                .shiftDate(shift.getShiftDate())
                .staffId(shift.getStaffId())
                .build();
    }

    // To return multiple objects, we utilise a list with our fromModels method.
    public static List<ShiftResource> fromModels(List<Shift> shifts) {
        List<ShiftResource> shiftResources = new ArrayList<>();
        for (Shift shift : shifts) {
            ShiftResource shiftResource = fromModel(shift);
            shiftResources.add(shiftResource);
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