package com.frederic.classpage.controllers;

import com.frederic.classpage.models.TeachingResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TeachingResourceController {

    @GetMapping("/resources")
    public String teachingResources(Model model) {
        List<TeachingResource> resources = new ArrayList<>();
        resources.add(new TeachingResource("Math Textbook", "Textbook for Math course", "/resources/math-textbook.pdf"));
        resources.add(new TeachingResource("Science Materials", "Materials for Science course", "/resources/science-materials.zip"));
        // 其他教材和資源...

        model.addAttribute("teachingResources", resources);
        return "resources"; // 對應到教材和資源的 HTML 模板文件
    }
}
