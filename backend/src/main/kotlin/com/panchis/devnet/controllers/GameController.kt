package com.panchis.devnet.controllers

import com.panchis.devnet.models.Game
import com.panchis.devnet.services.IGameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class GameController {

    @Autowired
    val gameService: IGameService? = null

    @GetMapping("/games")
    @CrossOrigin(
        // Access-Control-Allow-Origin
        origins = [ "*" ],

        // Alternative to origins that supports more flexible originpatterns.
        // Please, see CorsConfiguration.setAllowedOriginPatterns(List)for details.
        // originPatterns = { "" },

        // Access-Control-Allow-Credentials
        allowCredentials = "false",

        // Access-Control-Allow-Headers
        allowedHeaders = [ "*" ],

        // Access-Control-Expose-Headers
        exposedHeaders = [ "*" ],

        // Access-Control-Max-Age
        maxAge = 60 * 30,

        // Access-Control-Allow-Methods
        methods = [RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT]
    )
    fun getGames(): ResponseEntity<List<Game>> = gameService!!.listAll()

}