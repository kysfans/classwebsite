package com.frederic.classpage.controllers;
import com.frederic.classpage.models.Calender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalenderController {
    @GetMapping("/calender")
    public String viewCalendar(Model model) {
        List<Calender> calenders = new ArrayList<>();
        calenders.add(new Calender("1", LocalDate.of(2023, 8, 16),"哈哈","哈哈"));

        model.addAttribute("calender", calenders);
        return "calender"; // 對應到班級資訊的 HTML 模板文件
    }
}
