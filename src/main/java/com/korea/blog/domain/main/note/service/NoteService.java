package com.korea.blog.domain.main.note.service;

import com.korea.blog.domain.main.note.entity.Note;
import com.korea.blog.domain.main.note.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note saveDefault() {
        Note note = new Note();
        note.setTitle("new title...");
        note.setContent("");

        return noteRepository.save(note);
    }

    public List<Note> getList() {

        return noteRepository.findAll();
    }

    public Note getOne(long noteId) {

        return noteRepository.findById(noteId).orElseThrow();
    }

    public void modify(long noteId, String title, String content) {
        Note note = this.getOne(noteId);
        note.setTitle(title);
        note.setContent(content);

        noteRepository.save(note);
    }
}