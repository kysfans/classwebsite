package com.frederic.classpage.controllers;

import com.frederic.classpage.models.ClassPhoto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClassPhotoController {

    @GetMapping("/class-photos")
    public String classPhotos(Model model) {
        List<ClassPhoto> photos = new ArrayList<>();
        photos.add(new ClassPhoto("Classroom", "Our classroom setup", "/images/classroom.jpg"));
        photos.add(new ClassPhoto("Field Trip", "A memorable field trip", "/images/field-trip.jpg"));
        // 其他班級照片...

        model.addAttribute("classPhotos", photos);
        return "class-photos"; // 對應到班級照片的 HTML 模板文件
    }
}
