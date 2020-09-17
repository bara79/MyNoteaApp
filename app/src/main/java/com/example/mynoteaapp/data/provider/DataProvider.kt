package com.example.mynoteaapp.data.provider

import androidx.lifecycle.LiveData
import com.example.mynoteaapp.data.entity.Note
import com.example.mynoteaapp.data.model.NoteResult

interface DataProvider {
    fun subscribeToAllNotes() : LiveData<NoteResult>
    fun saveNote(note: Note) : LiveData<NoteResult>
    fun getNoteById(id: String) : LiveData<NoteResult>
}