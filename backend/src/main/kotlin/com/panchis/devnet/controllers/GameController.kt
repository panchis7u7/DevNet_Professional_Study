package com.panchis.devnet.controllers

import com.panchis.devnet.models.Game
import com.panchis.devnet.services.IGameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class GameController {

    @Autowired
    val gameService: IGameService? = null

    @GetMapping("/games")
    fun getGames(): ResponseEntity<List<Game>> = ResponseEntity(gameService!!.listAll(), HttpStatus.OK)

}