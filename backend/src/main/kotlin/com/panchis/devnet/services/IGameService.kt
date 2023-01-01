package com.panchis.devnet.services

import com.panchis.devnet.models.Game

interface IGameService {
    fun listAll(): List<Game>
}