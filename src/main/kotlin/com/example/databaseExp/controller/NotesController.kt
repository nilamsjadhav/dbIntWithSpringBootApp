package com.example.databaseExp.controller

import com.example.databaseExp.dto.NoteLabel
import com.example.databaseExp.dto.Response
import com.example.databaseExp.model.Note
import com.example.databaseExp.service.NotesService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

/** GET -> to display notes,
 * POST -> to add notes
 */
@RestController
@RequestMapping("/notes")
class NotesController(private val notesService: NotesService) {

  @GetMapping("/get-notes")
  fun getNotes(): MutableIterable<Note> {
    return notesService.get()
  }

  @PostMapping("/add-note", produces = [(MediaType.APPLICATION_JSON_VALUE)])
  fun addNote(@RequestBody note: NoteLabel): Response {
    notesService.save(note)
    return Response("Note add successfully")
  }

  @DeleteMapping("/remove-notes")
  fun removeNotes(): Response {
    notesService.remove()
    return Response("Removed all notes successfully")
  }
}