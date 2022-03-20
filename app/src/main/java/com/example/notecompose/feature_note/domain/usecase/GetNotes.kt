package com.example.notecompose.feature_note.domain.usecase

import com.example.notecompose.feature_note.domain.model.Note
import com.example.notecompose.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetNotes(
    private val repository: NoteRepository
) {
    operator fun invoke(): Flow<List<Note>> {
        return repository.getNotes()
    }
}
