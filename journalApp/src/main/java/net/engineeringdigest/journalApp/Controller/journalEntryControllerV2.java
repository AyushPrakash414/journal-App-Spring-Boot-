package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.entity.journalEntry;
import net.engineeringdigest.journalApp.service.journalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("journalV2")
public class journalEntryControllerV2 {

    @Autowired
    private journalEntryService jes;
    @PostMapping
    public boolean createEntry(@RequestBody journalEntry entry)
    {
        jes.SaveEntry(entry);
        return true;
    }
    @GetMapping
    public List<journalEntry> GetAllData()
    {
        return jes.GetAll();
    }
    @DeleteMapping("id/{myid}")
    public journalEntry DeleteJournalEntryById(@PathVariable long myid)
    {
        return null;
    }

}
