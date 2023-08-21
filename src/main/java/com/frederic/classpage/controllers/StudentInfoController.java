package com.frederic.classpage.controllers;

import com.frederic.classpage.models.StudentInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentInfoController {

    @GetMapping("/student-info")
    public String studentInfo(Model model) {
        StudentInfo studentInfo = new StudentInfo("Alice", 12345);

        model.addAttribute("studentInfo", studentInfo);
        return "student-info"; // 對應到學生資訊的 HTML 模板文件
    }
}
