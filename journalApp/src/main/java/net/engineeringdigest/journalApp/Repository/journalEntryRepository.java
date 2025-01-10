package net.engineeringdigest.journalApp.Repository;

import net.engineeringdigest.journalApp.entity.journalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalEntryRepository extends MongoRepository<journalEntry,String> {

}
