package com.frederic.classpage.controllers;

import com.frederic.classpage.models.CourseSchedule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CourseScheduleController {

    @GetMapping("/course-schedule")
    public String courseSchedule(Model model) {
        List<String> daysOfWeek = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
        List<List<String>> timeSlots = Arrays.asList(
                Arrays.asList("8:00 AM - 10:00 AM", "Math", "Room 101"),
                Arrays.asList("10:30 AM - 12:30 PM", "History", "Room 202")
                // 其他時間槽...
        );

        CourseSchedule courseSchedule = new CourseSchedule(daysOfWeek, timeSlots);

        model.addAttribute("courseSchedule", courseSchedule);
        return "course-schedule"; // 對應到課程表的 HTML 模板文件
    }
}
