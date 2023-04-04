package com.example.databaseExp.repository

import com.example.databaseExp.model.Note
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : CrudRepository<Note, Int> {
  fun save(note: Note)
  fun findAllById(id:Int): Note
}