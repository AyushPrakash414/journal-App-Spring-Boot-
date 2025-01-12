package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repository.journalEntryRepository;
import net.engineeringdigest.journalApp.entity.journalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class journalEntryService {
    @Autowired  //--> This annotation for the Dependency Injection;
    private journalEntryRepository journalEntryrepository;
    public void SaveEntry(journalEntry Journalentry)
    {
        journalEntryrepository.save(Journalentry);
    }

    public List<journalEntry> GetAll()
    {
        return journalEntryrepository.findAll();
    }
    public ResponseEntity deleteTheEntityById(String id)
    {
        if (journalEntryrepository.existsById(id))
        {
            journalEntryrepository.deleteById(id);
            return ResponseEntity.ok("Entity with ID " + id + " has been deleted.");
        }
        else
        {
            return ResponseEntity.status(404).body("Entity with ID " + id + " not found.");
        }
    }
    public Optional<journalEntry> GetEntityByItsId(String id) {
        return journalEntryrepository.findById(id); // Find journal entry by string ID
    }



}
