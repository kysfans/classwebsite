package com.frederic.classpage.controllers;

import com.frederic.classpage.services.AnnouncementsService;
import com.frederic.classpage.models.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AnnouncementController {

    private final AnnouncementsService announcementsService;

    @Autowired
    public AnnouncementController(AnnouncementsService announcementsService) {
        this.announcementsService = announcementsService;
    }

    @GetMapping("/announcements")
    public String announcements(Model model) {
        List<Announcement> announcementList = announcementsService.getAllAnnouncements();
        model.addAttribute("announcements", announcementList);
        model.addAttribute("newAnnouncement", new Announcement()); // Add this line
        return "announcements";
    }

    @PostMapping("/add-announcement")
    public String addAnnouncement(@RequestParam String title, @RequestParam String content, Model model) {
        announcementsService.insertAnnouncement(title, content);

        List<Announcement> announcementList = announcementsService.getAllAnnouncements();
        model.addAttribute("announcements", announcementList);
        return "redirect:/announcements";
    }
}
