/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<ShiftEntity, Integer> {

    List<ShiftEntity> findByStaffId(Integer staffId);

    List<ShiftEntity> findByStaffIdAndShiftDateGreaterThanAndShiftDateLessThan(Integer staffId, Instant now, Instant nextWeek);

    List<ShiftEntity> findByShiftDateGreaterThanAndShiftDateLessThan(Instant now, Instant nextWeek);

    /*

    // Same basic idea as above but allows you to specify exactly what you need. Hql = Hibernate Query Language. Use Hql when you need programs to be adaptable (can work between various languages etc).
    @Query("select shift from ShiftEntity shift where shift.staffId = :staffId and shift.shiftDate > :startDate and shift.shiftDate < :sevenDaysLater")
    List<ShiftEntity> findAWeeksShiftsForStaffByHqlQuery(Integer staffId, Instant startDate, Instant sevenDaysLater);

    // Same basic idea as above but allows you to specify exactly what you need. Sql = Sequel Query Language. Slightly faster, much less flexible than Hql.
    @Query(value = "select * from SHIFTS shift where shift.staff_id = :staffId AND shift.shift_date BETWEEN :startDate AND :sevenDaysLater ", nativeQuery = true)
    List<ShiftEntity> findAWeeksShiftsForStaffBySqlQuery(Integer staffId, Instant startDate, Instant sevenDaysLater);

     */
}
