CREATE TABLE IF NOT EXISTS "user"
(
    id bigserial NOT NULL,
    username character varying NOT NULL,
    password character varying NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS chatroom
(
    firstuser bigint NOT NULL,
    seconduser bigint NOT NULL,
    id bigserial NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS chatmessage
(
    text character varying NOT NULL,
    chatroom bigint NOT NULL,
    sender bigint NOT NULL,
    id bigserial NOT NULL,
    receiver bigint NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS chatroom
    ADD CONSTRAINT firstuserpk FOREIGN KEY (firstuser)
    REFERENCES "user" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS chatroom
    ADD CONSTRAINT seconduserpk FOREIGN KEY (seconduser)
    REFERENCES "user" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS chatmessage
    ADD CONSTRAINT chatroompk FOREIGN KEY (chatroom)
    REFERENCES chatroom (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS chatmessage
    ADD CONSTRAINT senderpk FOREIGN KEY (sender)
    REFERENCES "user" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS chatmessage
    ADD CONSTRAINT receiverpk FOREIGN KEY (receiver)
    REFERENCES "user" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
