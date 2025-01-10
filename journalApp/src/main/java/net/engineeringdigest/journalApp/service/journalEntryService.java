package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repository.journalEntryRepository;
import net.engineeringdigest.journalApp.entity.journalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class journalEntryService {
    @Autowired  //--> This annotation for the Dependency Injection;
    private journalEntryRepository journalEntryrepository;
    public void SaveEntry(journalEntry JournalEntry)
    {
        journalEntryrepository.save(JournalEntry);
    }

    public List<journalEntry> GetAll()
    {
        return journalEntryrepository.findAll();
    }

}
