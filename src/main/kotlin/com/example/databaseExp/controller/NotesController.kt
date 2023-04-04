package com.example.databaseExp.controller

import com.example.databaseExp.dto.NoteLabel
import com.example.databaseExp.dto.Response
import com.example.databaseExp.model.Note
import com.example.databaseExp.service.NotesService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
class NotesController(private val notesService: NotesService) {

  @GetMapping("/get-notes")
  fun getNotes(): ResponseEntity<MutableIterable<Note>> {
    return ResponseEntity.ok().body(notesService.get())
  }

  @PostMapping("/add-note", produces = [(MediaType.APPLICATION_JSON_VALUE)])
  fun addNote(@RequestBody note: NoteLabel): ResponseEntity<Response> {
    notesService.save(note)
    return ResponseEntity.ok(Response("Note add successfully"))
  }

  @DeleteMapping("/remove-notes")
  fun removeNotes(): ResponseEntity<Response> {
    notesService.remove()
    return ResponseEntity.ok(Response("Removed all notes successfully"))
  }
}