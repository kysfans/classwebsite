package com.frederic.classpage.controllers;

import com.frederic.classpage.models.graderecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradeRecordController {

    @GetMapping("/grade-record")
    public String gradeRecord(Model model) {
        List<graderecord> records = new ArrayList<>();
        records.add(new graderecord("Alice", "Math", 90.5));
        records.add(new graderecord("Bob", "History", 85.0));
        // 其他成績紀錄...

        model.addAttribute("gradeRecords", records);
        return "grade-record"; // 對應到成績紀錄的 HTML 模板文件
    }
}
