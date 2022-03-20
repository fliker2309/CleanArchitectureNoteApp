package com.example.notecompose.feature_note.domain.usecase

import com.example.notecompose.feature_note.domain.model.Note
import com.example.notecompose.feature_note.domain.repository.NoteRepository

class AddNote(private val repository: NoteRepository){
    suspend operator fun invoke(note: Note){
        repository.insertNote(note)
    }
}
