-- CREATE DATABASE devnet_games;

-- DROP TABLE games;

CREATE TABLE IF NOT EXISTS games (
    id UUID PRIMARY KEY NOT NULL,
    title VARCHAR(40) NOT NULL,
    lastTimePlayed TIMESTAMP NOT NULL,
    hoursPlayed DECIMAL(8,2) NOT NULL,
    releaseDate DATE NOT NULL,
    image VARCHAR(200)
);

INSERT INTO games (id, title, lastTimePlayed, hoursPlayed, releaseDate, image) VALUES ('7fa2470b-68a9-414c-a6c8-a0a17651104c', 'Doom Eternal', '2023-01-01 01:00:00', 7.34, '2020-09-14', 'https://images.ctfassets.net/rporu91m20dc/48FOwmEHJwz03qpd42nzwr/4f08db516cdcd51dc44d3c0474484b3b/doom_eternal_bg_date_m_w_launch.jpg?q=70');
INSERT INTO games (id, title, lastTimePlayed, hoursPlayed, releaseDate, image) VALUES ('80b8dd8c-1756-41b7-bc2b-a74f19987bb6', 'Tom Clancy: Ghost Recon Wildlands', '2019-12-22 14:32:11', 12.32, '2022-04-22', 'https://staticctf.akamaized.net/J3yJr34U2pZ2Ieem48Dwy9uqj5PNUQTn/1uU7lXYO5j5cLOqkbWSFRb/a21600951dfe27fbb701aae96f5d33b4/GRW_StandardEdition.jpg');
INSERT INTO games (id, title, lastTimePlayed, hoursPlayed, releaseDate, image) VALUES ('83c36994-4d8b-4a15-bff6-addd30ff959c', 'Elden Ring', '2021-04-22 17:53:43', 22.54, '2021-02-11', 'https://image.api.playstation.com/vulcan/ap/rnd/202110/2000/phvVT0qZfcRms5qDAk0SI3CM.png');
INSERT INTO games (id, title, lastTimePlayed, hoursPlayed, releaseDate, image) VALUES ('51b6a98b-1ed1-4b79-8ac6-13ad0c42854b', 'Red Dead Redemption 2', '2019-08-14 19:23:22', 1.94, '2022-12-22', 'https://image.api.playstation.com/gs2-sec/appkgo/prod/CUSA08519_00/12/i_3da1cf7c41dc7652f9b639e1680d96436773658668c7dc3930c441291095713b/i/icon0.png');

-- cat <path_to_this_file>/data.sql | sudo docker exec -i <postgres_container_name> psql -U $POSTGRES_USER $POSTGRES_DB
-- sudo docker exec -it <postgres_container_name> psql -U $POSTGRES_USER -d $POSTGRES_DB -c "SELECT * FROM games;"
