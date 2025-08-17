package com.youtube.db_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Video entity representing videos in the system
 */
@Entity
@Table(name = "videos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID videoId;
    
    @Column(nullable = false)
    private String videoTitle;
    
    @Column(name = "total_likes")
    private Long totalLikes = 0L;
    
    @Column(name = "video_link", nullable = false)
    private String videoLink;
    
    @Column
    private String category;
    
    // Many-to-One relationship with Channel
    @ManyToOne
    private Channel channel;

    @OneToMany
    private List<Comment> comments;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
