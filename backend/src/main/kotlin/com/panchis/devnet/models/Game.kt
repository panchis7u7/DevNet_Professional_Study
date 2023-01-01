package com.panchis.devnet.models

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "games")
data class Game(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id") @JsonProperty("id") val id: UUID,
    @Column(name = "title") @JsonProperty("title") val title: String,
    @Column(name = "lasttimeplayed") @JsonProperty("lastTimePlayed") val lastTimePlayed: Date,
    @Column(name = "hoursplayed") @JsonProperty("hoursPlayed") val hoursPlayed: Float,
    @Column(name = "releasedate") @JsonProperty("releaseDate") val releaseDate: Date,
    @Column(name = "image") @JsonProperty("image") val image: String
){}