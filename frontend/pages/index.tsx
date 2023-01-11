import MediaCard from './components/MediaCard';
import { Inter } from '@next/font/google'
import { useEffect, useState } from 'react'
import { Game } from '../models/game';
import { Grid } from '@mui/material';

const inter = Inter({ subsets: ['latin'] })

export default function Home() {
  const [games, setGames] = useState<Array<Game>>([]);

  useEffect(() => {
    fetch(`http://${process.env.NEXT_PUBLIC_BACKEND_HOST}:${process.env.NEXT_PUBLIC_BACKEND_PORT}/api/v1/games`, { method: "GET" })
      .then(response => response.json())
      .then(jsonResponse => {
        jsonResponse as Array<Game>;
        console.log(jsonResponse)
        setGames(jsonResponse);
      }).catch(e => {
        console.log(e)
      })
  }, []);

  return (
    <Grid container spacing={3} columns={16}>
      {games.map(game => (
        <Grid key={game.id} item xs={8} lg={4}>
          <MediaCard {...game} />
        </Grid>
      ))}
    </Grid>
  );
}
