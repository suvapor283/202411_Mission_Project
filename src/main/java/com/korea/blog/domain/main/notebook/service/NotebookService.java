package com.korea.blog.domain.main.notebook.service;

import com.korea.blog.domain.main.notebook.entity.Notebook;
import com.korea.blog.domain.main.notebook.repository.NotebookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotebookService {

    private final NotebookRepository notebookRepository;

    public List<Notebook> getList() {

        return notebookRepository.findAll();
    }

    public void saveDefault() {
        Notebook notebook = new Notebook();
        notebook.setName("New book..");

        notebookRepository.save(notebook);
    }
}
