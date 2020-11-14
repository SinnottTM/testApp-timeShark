package com.tim.application.timeShark.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class WeeklyStaff {

    List<Staff> staff;
    List<Shift> shifts;
}
