package com.esvarog.ua.Dekanat.model.table;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "logs")
public class LogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private String message;
    public LogEntry() {
        // Порожній конструктор для JPA
    }
    public LogEntry(LocalDateTime timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }
    // Геттери і сеттери
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
