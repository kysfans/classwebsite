package com.frederic.classpage.controllers;

import com.frederic.classpage.models.ClassInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassInfoController {

    @GetMapping("/class-info")
    public String classInfo(Model model) {
        ClassInfo classInfo = new ClassInfo("Class A", "123", "John Doe");

        model.addAttribute("classInfo", classInfo);
        return "class-info"; // 對應到班級資訊的 HTML 模板文件
    }
}


