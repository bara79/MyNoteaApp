package com.example.mynoteaapp.ui.note

import com.example.mynoteaapp.data.entity.Note
import com.example.mynoteaapp.ui.base.BaseViewState

class NoteViewState(note: Note? = null, error: Throwable? = null) : BaseViewState<Note?>(note, error)