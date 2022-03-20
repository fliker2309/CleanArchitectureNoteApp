package com.example.notecompose.feature_note.domain.usecase

data class NoteUseCases(
    val deleteNote: DeleteNote,
    val getNoteById: GetNoteById,
    val getNotes: GetNotes,
    val addNote: AddNote
)
