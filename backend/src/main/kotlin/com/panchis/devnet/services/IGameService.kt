package com.panchis.devnet.services

import com.panchis.devnet.models.Game
import org.springframework.http.ResponseEntity

interface IGameService {
    fun listAll(): ResponseEntity<List<Game>>
}