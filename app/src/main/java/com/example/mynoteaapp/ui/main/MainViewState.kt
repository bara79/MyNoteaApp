package com.example.mynoteaapp.ui.main

import com.example.mynoteaapp.data.entity.Note
import com.example.mynoteaapp.ui.base.BaseViewState


class MainViewState(val notes: List<Note>? = null, error: Throwable? = null) : BaseViewState<List<Note>?>(notes, error)