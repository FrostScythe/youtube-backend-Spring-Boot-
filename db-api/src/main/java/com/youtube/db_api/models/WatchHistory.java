package com.youtube.db_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * WatchHistory entity representing user video viewing history
 */
@Entity
@Table(name = "watch_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatchHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    // Many-to-One relationship with User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    // Many-to-One relationship with Video
    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;
    
    @Column(name = "watched_time", nullable = false)
    private LocalDateTime watchedTime;
    
    @Column(name = "is_liked")
    private boolean isLiked = false;
    
    @Column(name = "is_commented")
    private boolean isCommented = false;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
