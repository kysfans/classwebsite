package com.frederic.classpage.services;

import com.frederic.classpage.mappers.AnnouncementMapper;
import com.frederic.classpage.models.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnnouncementsService {
    private final AnnouncementMapper announcementMapper;

    @Autowired
    public AnnouncementsService(AnnouncementMapper announcementMapper) {
        this.announcementMapper = announcementMapper;
    }

    public void insertAnnouncement(String title, String content) {
        Announcement newAnnouncement = new Announcement();
        newAnnouncement.setTitle(title);
        newAnnouncement.setContent(content);
        newAnnouncement.setCreatedAt(new Date());

        announcementMapper.insertAnnouncement(newAnnouncement);
    }

    public List<Announcement> getAllAnnouncements() {
        return announcementMapper.getAllAnnouncements();
    }
}
