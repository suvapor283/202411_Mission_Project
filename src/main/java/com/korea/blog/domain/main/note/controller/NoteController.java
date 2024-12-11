package com.korea.blog.domain.main.note.controller;

import com.korea.blog.domain.main.note.entity.Note;
import com.korea.blog.domain.main.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/write")
    public String write() {
        noteService.saveDefault();

        return "redirect:/";
    }

    @GetMapping("")
    public String list() {

        return "main";
    }

    @GetMapping("/{noteId}")
    public String main(Model model, @PathVariable long noteId) {
        List<Note> noteList = noteService.getList();
        Note selectedNote = noteService.getOne(noteId);

        model.addAttribute("noteList", noteList);
        model.addAttribute("selectedNote", selectedNote);

        return "main";
    }
}