package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import exceptions.ResourceNotFoundException;
import models.Note;
import repositories.NoteRepository;

@Service
public class NoteService {

	@Autowired
	NoteRepository noteRepo;

	
	public List<Note> allNotes() {
		return noteRepo.findAll();
	}

	public Note saveNotes(@RequestBody Note note) {
		return noteRepo.save(note);
	}

	public ResponseEntity<Note> getById(@PathVariable long id) {
		Optional<Note> notes = noteRepo.findById(id);
		if (notes.isPresent()) {
			return new ResponseEntity<Note>(notes.get(), HttpStatus.OK);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	public void verifyIfExist(Long id) {
		if (noteRepo.findById(id) == null) {
			throw new ResourceNotFoundException("the note with the id: " + id + "");
		}
	}
}
