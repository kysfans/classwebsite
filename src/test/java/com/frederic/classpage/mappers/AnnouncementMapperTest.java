package com.frederic.classpage.mappers;
import com.frederic.classpage.models.Announcement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AnnouncementMapperTest {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Test
    public void testInsertAnnouncement() {
        Announcement announcement = new Announcement();
        announcement.setTitle("Test Title");
        announcement.setContent("Test Content");
        announcement.setCreatedAt(new Date());

        announcementMapper.insertAnnouncement(announcement);

        List<Announcement> announcements = announcementMapper.getAllAnnouncements();
        assertEquals(1, announcements.size());
        assertEquals("Test Title", announcements.get(0).getTitle());
        assertEquals("Test Content", announcements.get(0).getContent());
    }

    @Test
    public void testGetAllAnnouncements() {
        Announcement announcement1 = new Announcement();
        announcement1.setTitle("Title 1");
        announcement1.setContent("Content 1");
        announcement1.setCreatedAt(new Date());
        announcementMapper.insertAnnouncement(announcement1);

        Announcement announcement2 = new Announcement();
        announcement2.setTitle("Title 2");
        announcement2.setContent("Content 2");
        announcement2.setCreatedAt(new Date());
        announcementMapper.insertAnnouncement(announcement2);

        List<Announcement> announcements = announcementMapper.getAllAnnouncements();
        assertEquals(2, announcements.size());
        assertEquals("Title 1", announcements.get(0).getTitle());
        assertEquals("Content 1", announcements.get(0).getContent());
        assertEquals("Title 2", announcements.get(1).getTitle());
        assertEquals("Content 2", announcements.get(1).getContent());
    }
}
