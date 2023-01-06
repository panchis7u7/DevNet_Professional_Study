package com.panchis.devnet.controllers

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

import com.panchis.devnet.models.Game
import com.panchis.devnet.services.IGameService
import org.hamcrest.Matchers
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import java.nio.charset.Charset
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@ExtendWith(SpringExtension::class)
@WebMvcTest(GameController::class)
class GameControllerTest {

    @Autowired
    val mockMvc: MockMvc? = null

    @MockBean
    val gameService: IGameService? = null

    private val APPLICATION_JSON_UTF8: MediaType = MediaType(
        MediaType.APPLICATION_JSON.type,
        MediaType.APPLICATION_JSON.subtype,
        Charset.forName("utf8")
    )

    @DisplayName("GameController -> HTTP GET getGames() -> test.")
    @Test
    fun getGamesTest() {
        val testGames: List<Game> = Arrays.asList(
            Game(UUID.randomUUID(), "God of War", LocalDateTime.now(), 73.2f, LocalDate.now(), "test.png"),
            Game(UUID.randomUUID(), "Elden Ring", LocalDateTime.now(), 73.2f, LocalDate.now(), "test.png"),
        )

        val mockResponse: ResponseEntity<List<Game>> = ResponseEntity.of<List<Game>>(Optional.of(testGames))
        Mockito.`when`(gameService?.listAll()).thenReturn(mockResponse)
        mockMvc?.perform(get("/api/v1/games").contentType(APPLICATION_JSON_UTF8))
            ?.andExpect(status().isOk)
            ?.andExpect(jsonPath("$", Matchers.hasSize<List<Game>>(3)))
    }
}