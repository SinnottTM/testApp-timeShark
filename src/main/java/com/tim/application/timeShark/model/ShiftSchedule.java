package com.tim.application.timeShark.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ShiftSchedule {

        List<Staff> staff;
        Shift shift;
}

