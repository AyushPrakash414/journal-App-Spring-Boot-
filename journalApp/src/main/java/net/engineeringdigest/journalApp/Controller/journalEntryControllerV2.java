package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.entity.journalEntry;
import net.engineeringdigest.journalApp.service.journalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity DeleteJournalEntryById(@PathVariable long myid)
    {
        String id=Long.toString(myid);
        return jes.deleteTheEntityById(id);
    }
    @GetMapping("id/{myid}")
    public journalEntry getEntityById(@PathVariable long myid) {
        String convertedID = Long.toString(myid); // Convert long to String
        return jes.GetEntityByItsId(convertedID).orElse(null); // Fetch entity by ID
    }

    @GetMapping("UpDateTheEntry/{id}")
    public journalEntry UpdatejournalEntryById(@PathVariable long id,@RequestBody journalEntry temp)
    {
        String ConvertedId=Long.toString(id);
        journalEntry oldEntry=jes.GetEntityByItsId(ConvertedId).orElse(null);
        if(oldEntry!=null)
        {
             jes.SaveEntry(temp);
             return temp;
        }
        else
        {
            return null;
        }
    }

}
