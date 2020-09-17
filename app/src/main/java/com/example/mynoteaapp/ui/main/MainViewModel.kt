package com.example.mynoteaapp.ui.main
import androidx.lifecycle.Observer
import com.example.mynoteaapp.data.NotesRepository
import com.example.mynoteaapp.data.entity.Note
import com.example.mynoteaapp.data.model.NoteResult
import com.example.mynoteaapp.ui.base.BaseViewModel


class MainViewModel() : BaseViewModel<List<Note>?, MainViewState>() {

    private val notesObserver = Observer<NoteResult> { result ->
        result ?: return@Observer
        when(result){
            is NoteResult.Success<*> ->  viewStateLiveData.value = MainViewState(notes = result.data as? List<Note>)
            is NoteResult.Error -> viewStateLiveData.value = MainViewState(error = result.error)
        }
    }

    private val repositoryNotes = NotesRepository.getNotes()

    init {
        viewStateLiveData.value = MainViewState()
        repositoryNotes.observeForever (notesObserver)
    }

    override fun onCleared() {
        super.onCleared()
        repositoryNotes.removeObserver(notesObserver)
    }
}