package com.panchis.devnet.services

import com.panchis.devnet.exceptions.GameException
import com.panchis.devnet.models.Game
import com.panchis.devnet.repositories.IGameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class GameService: IGameService {

    @Autowired
    val gamesRepo: IGameRepository? = null

    override fun listAll(): ResponseEntity<List<Game>> {
        try {
            return ResponseEntity.accepted()
                .headers(HttpHeaders())
                .body(gamesRepo!!.findAll().toList())
        } catch (e: Exception) {
            throw GameException(e.message!!)
        }
    }
}