package com.example.databaseExp.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "notes")
data class Note(
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long = 0,

  @Column
  var description: String? = null,

  @Column
  var createdAt: Date? = null,

  @Column
  var label: String? = null
)
