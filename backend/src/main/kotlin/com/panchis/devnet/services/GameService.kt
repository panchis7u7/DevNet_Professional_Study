package com.panchis.devnet.services

import com.panchis.devnet.exceptions.GameException
import com.panchis.devnet.models.Game
import com.panchis.devnet.repositories.IGameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class GameService: IGameService {

    @Autowired
    val gamesRepo: IGameRepository? = null

    override fun listAll(): List<Game> {
        try {
            return gamesRepo!!.findAll() as List<Game>
        } catch (e: Exception) {
            throw GameException(e.message!!)
        }
    }
}