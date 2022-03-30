package com.example.notecompose.di

import android.app.Application
import androidx.room.Room
import com.example.notecompose.feature_note.data.data_source.NoteDatabase
import com.example.notecompose.feature_note.data.repository.NoteRepositoryImpl
import com.example.notecompose.feature_note.domain.repository.NoteRepository
import com.example.notecompose.feature_note.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            deleteNote = DeleteNote(repository),
            getNotes = GetNotes(repository),
            getNoteById = GetNoteById(repository),
            addNote = AddNote(repository)
        )
    }
}
