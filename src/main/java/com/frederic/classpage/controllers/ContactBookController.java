package com.frederic.classpage.controllers;

import com.frederic.classpage.models.ContactBookEntry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactBookController {

    @GetMapping("/contact-book")
    public String contactBook(Model model) {
        List<ContactBookEntry> entries = new ArrayList<>();
        entries.add(new ContactBookEntry("Alice", "Math Homework", "Remember to complete the math homework."));
        entries.add(new ContactBookEntry("Bob", "History Project", "Your history project is due next week. Keep up the good work!"));
        // 其他聯絡簿項目...

        model.addAttribute("contactBookEntries", entries);
        return "contact-book"; // 對應到聯絡簿的 HTML 模板文件
    }
}
