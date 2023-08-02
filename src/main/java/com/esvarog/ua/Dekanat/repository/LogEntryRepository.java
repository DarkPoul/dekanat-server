package com.esvarog.ua.Dekanat.repository;

import com.esvarog.ua.Dekanat.model.table.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {

}

