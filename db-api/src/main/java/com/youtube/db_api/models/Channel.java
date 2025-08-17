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
 * Channel entity representing YouTube channels in the system
 */
@Entity
@Table(name = "channels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID channelId;
    
    @Column(nullable = false, unique = true)
    private String channelName;
    
    private String channelDescription;
    
    @Column(name = "total_view_count")
    private Long channelTotalViewCount = 0L;
    
    @Column(name = "total_subscribers")
    private Long totalChannelSubscribers = 0L;
    
    // Many-to-One relationship with User (Channel Owner)
    @ManyToOne
    private User channelOwner;

    @ManyToMany
    private List<User> channelSubscribers;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
