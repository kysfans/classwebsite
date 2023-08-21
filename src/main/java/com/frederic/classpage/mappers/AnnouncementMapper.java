package com.frederic.classpage.mappers;

import com.frederic.classpage.models.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.frederic.classpage.models.Announcement;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnnouncementMapper {
    @Insert("INSERT INTO announcements (title, content, created_at) VALUES (#{title}, #{content}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertAnnouncement(Announcement announcement);

    @Select("SELECT * FROM announcements")
    List<Announcement> getAllAnnouncements();
}

