package com.example.mynoteaapp.data

import com.example.mynoteaapp.data.entity.Note
import com.example.mynoteaapp.data.provider.DataProvider
import com.example.mynoteaapp.data.provider.FirestoreProvider

object NotesRepository {

    private val dataProvider: DataProvider = FirestoreProvider()

    fun getNotes() = dataProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = dataProvider.saveNote(note)
    fun getNoteById(id: String) = dataProvider.getNoteById(id)

}
