package com.klu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.entity.Content;
import com.klu.repository.ContentRepository;

@Service
public class ContentService {

    private final ContentRepository repository;

    public ContentService(ContentRepository repository) {

        this.repository = repository;
    }

    public Content addContent(Content content) {

        return repository.save(content);
    }

    public List<Content> getAllContent() {

        return repository.findAll();
    }

    public Content getContent(Long id) {

        return repository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException("Content not found")
                );
    }

    public Content updateContent(Long id,
                                 Content newContent) {

        Content oldContent = getContent(id);

        oldContent.setTitle(newContent.getTitle());

        oldContent.setAuthor(newContent.getAuthor());

        oldContent.setType(newContent.getType());

        oldContent.setCategory(newContent.getCategory());

        oldContent.setDescription(
                newContent.getDescription()
        );

        oldContent.setFilePath(
                newContent.getFilePath()
        );

        oldContent.setPublisherId(
                newContent.getPublisherId()
        );

        oldContent.setPublishedDate(
                newContent.getPublishedDate()
        );

        return repository.save(oldContent);
    }

    public String deleteContent(Long id) {

        repository.deleteById(id);

        return "Content deleted successfully";
    }
}