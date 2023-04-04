package com.example.databaseExp.service

import com.example.databaseExp.dto.NoteLabel
import com.example.databaseExp.model.Note
import com.example.databaseExp.repository.NoteRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class NotesService(private val noteRepository: NoteRepository) {

  fun save(note: NoteLabel) {
    println(Note(description = note.description, createdAt = Date()))
    noteRepository.save(Note(description = note.description, createdAt = Date()))
  }

  fun get(): MutableIterable<Note> {
    return noteRepository.findAll()
  }

  fun remove() {
    noteRepository.deleteAll()
  }
}
