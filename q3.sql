
CREATE TABLE public.instrument (
                name VARCHAR NOT NULL,
                pitch INTEGER NOT NULL,
                CONSTRAINT instrument_id PRIMARY KEY (name)
);


CREATE TABLE public.address (
                address_id INTEGER NOT NULL,
                street1 VARCHAR NOT NULL,
                street2 VARCHAR NOT NULL,
                number VARCHAR NOT NULL,
                city VARCHAR NOT NULL,
                state VARCHAR NOT NULL,
                zip_code VARCHAR NOT NULL,
                telephone VARCHAR NOT NULL,
                CONSTRAINT address_pk PRIMARY KEY (address_id)
);


CREATE TABLE public.musician (
                ssn INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                address_id INTEGER NOT NULL,
                CONSTRAINT musician_pk PRIMARY KEY (ssn)
);


CREATE TABLE public.album (
                album_id INTEGER NOT NULL,
                title VARCHAR NOT NULL,
                release_date DATE NOT NULL,
                format VARCHAR NOT NULL,
                age TIME NOT NULL,
                ssn INTEGER NOT NULL,
                CONSTRAINT album_pk PRIMARY KEY (album_id)
);


CREATE TABLE public.song (
                title VARCHAR NOT NULL,
                length INTEGER NOT NULL,
                album_id INTEGER NOT NULL,
                ssn INTEGER NOT NULL,
                CONSTRAINT song_pk PRIMARY KEY (title)
);


CREATE TABLE public.use (
                name VARCHAR NOT NULL,
                title VARCHAR NOT NULL,
                CONSTRAINT use_pk PRIMARY KEY (name, title)
);


CREATE TABLE public.performs (
                ssn INTEGER NOT NULL,
                title VARCHAR NOT NULL,
                CONSTRAINT performs_pk PRIMARY KEY (ssn, title)
);


CREATE TABLE public.plays (
                ssn INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                CONSTRAINT plays_pk PRIMARY KEY (ssn, name)
);


ALTER TABLE public.plays ADD CONSTRAINT instrument_musicians_instruments_fk
FOREIGN KEY (name)
REFERENCES public.instrument (name)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.use ADD CONSTRAINT instrument_songs_instruments_fk
FOREIGN KEY (name)
REFERENCES public.instrument (name)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.musician ADD CONSTRAINT address_musician_fk
FOREIGN KEY (address_id)
REFERENCES public.address (address_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.plays ADD CONSTRAINT musician_musicians_instruments_fk
FOREIGN KEY (ssn)
REFERENCES public.musician (ssn)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.performs ADD CONSTRAINT musician_performs_fk
FOREIGN KEY (ssn)
REFERENCES public.musician (ssn)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.album ADD CONSTRAINT musician_album_fk
FOREIGN KEY (ssn)
REFERENCES public.musician (ssn)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.song ADD CONSTRAINT musician_song_fk
FOREIGN KEY (ssn)
REFERENCES public.musician (ssn)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.song ADD CONSTRAINT album_song_fk
FOREIGN KEY (album_id)
REFERENCES public.album (album_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.use ADD CONSTRAINT song_songs_instruments_fk
FOREIGN KEY (title)
REFERENCES public.song (title)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.performs ADD CONSTRAINT song_performs_fk
FOREIGN KEY (title)
REFERENCES public.song (title)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;