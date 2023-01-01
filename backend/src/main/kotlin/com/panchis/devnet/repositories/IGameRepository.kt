package com.panchis.devnet.repositories

import com.panchis.devnet.models.Game
import org.springframework.data.repository.CrudRepository
import java.util.UUID
interface IGameRepository: CrudRepository<Game, UUID> {}