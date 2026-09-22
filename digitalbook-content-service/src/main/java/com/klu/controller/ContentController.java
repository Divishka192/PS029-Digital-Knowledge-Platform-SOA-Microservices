package com.klu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.entity.Content;
import com.klu.service.ContentService;

@RestController
@RequestMapping("/content")
public class ContentController {

    private final ContentService service;

    public ContentController(ContentService service) {

        this.service = service;
    }

    @PostMapping
    public Content addContent(
            @RequestBody Content content) {

        return service.addContent(content);
    }

    @GetMapping
    public List<Content> getAllContent() {

        return service.getAllContent();
    }

    @GetMapping("/{id}")
    public Content getContent(
            @PathVariable Long id) {

        return service.getContent(id);
    }

    @PutMapping("/{id}")
    public Content updateContent(
            @PathVariable Long id,
            @RequestBody Content content) {

        return service.updateContent(id, content);
    }

    @DeleteMapping("/{id}")
    public String deleteContent(
            @PathVariable Long id) {

        return service.deleteContent(id);
    }
}