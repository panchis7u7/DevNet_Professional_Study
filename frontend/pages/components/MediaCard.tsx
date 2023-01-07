import * as React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { Game } from '../../models/game';

const MediaCard = (game: Game) => (
    <Card sx={{ maxWidth: 500 }} elevation={10}>
        <CardMedia
            sx={{ height: 140 }}
            image={game.image}
            title={game.title}
        />
        <CardContent>
            <Typography gutterBottom variant="h5" component="div">
                {game.title}
            </Typography>
            <Typography variant="body2" color="text.secondary">
                {`Total time played: ${game.hoursPlayed}.\n`}
                <br></br>
                {`Last time played on: ${game.lastTimePlayed}.`}
            </Typography>
        </CardContent>
        <CardActions>
            <Button size="small">Share</Button>
            <Button size="small">Learn More</Button>
        </CardActions>
    </Card>
);

export default MediaCard;