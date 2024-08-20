CREATE TABLE IF NOT EXISTS public.contacts
(
    id bigserial NOT NULL,
    first bigint NOT NULL,
    second bigint NOT NULL,
    chatid bigint,
    CONSTRAINT contacts_pkey PRIMARY KEY (id)
);


ALTER TABLE IF EXISTS public.contacts
    ADD CONSTRAINT chat_pk FOREIGN KEY (chatid)
    REFERENCES public.chatroom (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.contacts
    ADD CONSTRAINT first_pk FOREIGN KEY (first)
    REFERENCES public."user" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.contacts
    ADD CONSTRAINT second_pk FOREIGN KEY (second)
    REFERENCES public."user" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
