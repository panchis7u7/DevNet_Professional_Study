import { Inter } from '@next/font/google'
import { useEffect, useState } from 'react'
import { Game } from '../models/game';
import MediaCard from './components/MediaCard';
import { Grid } from '@mui/material';

const inter = Inter({ subsets: ['latin'] })

export default function Home() {
  const [games, setGames] = useState<Array<Game>>([]);

  useEffect(() => {
    fetch("http://192.168.1.110:8080/api/v1/games", { method: "GET" })
      .then(response => response.json())
      .then(jsonResponse => {
        jsonResponse as Array<Game>;
        console.log(jsonResponse)
        setGames(jsonResponse);
      })
  }, []);

  return (
    <Grid container spacing={3} columns={16}>
      {games.map(game => (
        <Grid item xs={8} lg={4}>
          <MediaCard key={game.id} {...game} />
        </Grid>
      ))}
    </Grid>
  );
}
