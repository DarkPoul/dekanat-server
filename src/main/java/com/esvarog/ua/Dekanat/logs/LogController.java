package com.esvarog.ua.Dekanat.logs;

import com.esvarog.ua.Dekanat.model.table.LogEntry;
import com.esvarog.ua.Dekanat.repository.LogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    private final LogEntryRepository logEntryRepository;

    @Autowired
    public LogController(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    @GetMapping
    public List<LogEntry> getAllLogs() {
        return logEntryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<LogEntry> createLogEntry(@RequestBody String message) {
        LogEntry logEntry = new LogEntry(LocalDateTime.now(), message);
        LogEntry savedLogEntry = logEntryRepository.save(logEntry);
        return new ResponseEntity<>(savedLogEntry, HttpStatus.CREATED);
    }
}

