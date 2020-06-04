package controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Note;
import repositories.NoteRepository;
import service.NoteService;

@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired
	NoteRepository noteRepo;

	@Autowired
	NoteService noteService;

	@GetMapping("/getAllNotes")
	public ResponseEntity<List<Note>> listNotes() {
		List<Note> notes = noteService.allNotes();
		
		return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
	}

	@PostMapping("/saveNotes")
	public ResponseEntity<Note> createNotes(@Validated @RequestBody Note note) {
		Note notes = noteService.saveNotes(note);

		return new ResponseEntity<Note>(HttpStatus.CREATED);
	}

	@GetMapping("/getNote/{id}")
	public ResponseEntity<Note> getById(@PathVariable(value = "id") long id) {
		
		return noteService.getById(id);
	}

	@PutMapping("getNote/{id}")
	public ResponseEntity<Note> updateNote(@PathVariable(value = "id") long id,
								@RequestBody @Validated Note notes ) {
		Optional<Note> noteS = noteRepo.findById(id);
		if(noteS.isPresent()) {
			notes.setId(noteS.get().getId());
			return new ResponseEntity<Note>(noteRepo.save(notes), HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
			
	}

}
