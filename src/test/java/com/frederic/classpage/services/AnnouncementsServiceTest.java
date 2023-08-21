package com.frederic.classpage.services;

import com.frederic.classpage.mappers.AnnouncementMapper;
import com.frederic.classpage.models.Announcement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

public class AnnouncementsServiceTest {

    private AnnouncementsService announcementsService;

    @Mock
    private AnnouncementMapper announcementMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        announcementsService = new AnnouncementsService(announcementMapper);
    }

    @Test
    public void testInsertAnnouncement() {
        Announcement expectedAnnouncement = new Announcement();
        expectedAnnouncement.setTitle("Test Title");
        expectedAnnouncement.setContent("Test Content");
        expectedAnnouncement.setCreatedAt(new Date());

        announcementsService.insertAnnouncement(expectedAnnouncement.getTitle(), expectedAnnouncement.getContent());

        verify(announcementMapper, times(1)).insertAnnouncement(expectedAnnouncement);
    }


    @Test
    public void testGetAllAnnouncements() {
        List<Announcement> mockAnnouncements = new ArrayList<>();
        mockAnnouncements.add(new Announcement("Title 1", "Content 1", new Date()));
        mockAnnouncements.add(new Announcement("Title 2", "Content 2", new Date()));

        when(announcementMapper.getAllAnnouncements()).thenReturn(mockAnnouncements);

        List<Announcement> announcements = announcementsService.getAllAnnouncements();

        verify(announcementMapper, times(1)).getAllAnnouncements();
        // You can also perform assertions on 'announcements' to match with 'mockAnnouncements'
    }
}
