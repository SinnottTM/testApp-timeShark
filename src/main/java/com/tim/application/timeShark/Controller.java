/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tim.application.timeShark;

import com.tim.application.timeShark.db.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Autowired
    StaffRepository staffRepository;

    /*
    @Autowired
    StaffFactory staffFactory;

    @GetMapping(value = "/revealAll")
    public List<StaffEntity> getAll() {
        return staffService.getAll();
    }

    @GetMapping(value = "/addStaff")
    public void addStaff (@RequestMapping int id, @RequestMapping boolean management, @RequestMapping String name, @RequestMapping String contract, @RequestMapping int hours) {
        if ()
    }

    @GetMapping(value = "/deleteStaff")
    public void deleteStaff(@RequestParam int id) {
        staffService.deleteCharacter(id);
    }

    @GetMapping(value = "/totalHours")
    public int totalHours() {
        return staffService.totalHours();
    }

    */
}