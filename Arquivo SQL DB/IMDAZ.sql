--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-04-26 19:58:28

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 853 (class 1247 OID 16654)
-- Name: genero_enum; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.genero_enum AS ENUM (
    'MASCULINO',
    'FEMININO'
);


ALTER TYPE public.genero_enum OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 222 (class 1259 OID 16715)
-- Name: aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aluno (
    aluno_id integer NOT NULL,
    pessoa_id integer,
    escola character varying(100),
    matricula character varying(50),
    possui_laudo boolean,
    medianotas double precision,
    anoletivo character varying(10)
);


ALTER TABLE public.aluno OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16714)
-- Name: aluno_aluno_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.aluno_aluno_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.aluno_aluno_id_seq OWNER TO postgres;

--
-- TOC entry 4933 (class 0 OID 0)
-- Dependencies: 221
-- Name: aluno_aluno_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.aluno_aluno_id_seq OWNED BY public.aluno.aluno_id;


--
-- TOC entry 218 (class 1259 OID 16667)
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco (
    endereco_id integer NOT NULL,
    bairro character varying(100),
    rua character varying(100),
    numero character varying(10),
    cep character varying(10)
);


ALTER TABLE public.endereco OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16666)
-- Name: endereco_endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endereco_endereco_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.endereco_endereco_id_seq OWNER TO postgres;

--
-- TOC entry 4934 (class 0 OID 0)
-- Dependencies: 217
-- Name: endereco_endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.endereco_endereco_id_seq OWNED BY public.endereco.endereco_id;


--
-- TOC entry 220 (class 1259 OID 16703)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoa (
    pessoa_id integer NOT NULL,
    nome character varying(100),
    data_nasc date,
    telefone character varying(15),
    genero public.genero_enum,
    endereco_id integer
);


ALTER TABLE public.pessoa OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16702)
-- Name: pessoa_pessoa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pessoa_pessoa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pessoa_pessoa_id_seq OWNER TO postgres;

--
-- TOC entry 4935 (class 0 OID 0)
-- Dependencies: 219
-- Name: pessoa_pessoa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pessoa_pessoa_id_seq OWNED BY public.pessoa.pessoa_id;


--
-- TOC entry 224 (class 1259 OID 16727)
-- Name: responsavel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responsavel (
    responsavel_id integer NOT NULL,
    pessoa_id integer,
    parentesco character varying(50),
    guardiao_legal boolean
);


ALTER TABLE public.responsavel OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16726)
-- Name: responsavel_responsavel_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.responsavel_responsavel_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.responsavel_responsavel_id_seq OWNER TO postgres;

--
-- TOC entry 4936 (class 0 OID 0)
-- Dependencies: 223
-- Name: responsavel_responsavel_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.responsavel_responsavel_id_seq OWNED BY public.responsavel.responsavel_id;


--
-- TOC entry 4762 (class 2604 OID 16718)
-- Name: aluno aluno_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno ALTER COLUMN aluno_id SET DEFAULT nextval('public.aluno_aluno_id_seq'::regclass);


--
-- TOC entry 4760 (class 2604 OID 16670)
-- Name: endereco endereco_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco ALTER COLUMN endereco_id SET DEFAULT nextval('public.endereco_endereco_id_seq'::regclass);


--
-- TOC entry 4761 (class 2604 OID 16706)
-- Name: pessoa pessoa_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa ALTER COLUMN pessoa_id SET DEFAULT nextval('public.pessoa_pessoa_id_seq'::regclass);


--
-- TOC entry 4763 (class 2604 OID 16730)
-- Name: responsavel responsavel_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsavel ALTER COLUMN responsavel_id SET DEFAULT nextval('public.responsavel_responsavel_id_seq'::regclass);


--
-- TOC entry 4925 (class 0 OID 16715)
-- Dependencies: 222
-- Data for Name: aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.aluno (aluno_id, pessoa_id, escola, matricula, possui_laudo, medianotas, anoletivo) FROM stdin;
3	3	esfa	2032032	t	7	8
4	10	 Assis Brasil	43989834	t	8	9
\.


--
-- TOC entry 4921 (class 0 OID 16667)
-- Dependencies: 218
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endereco (endereco_id, bairro, rua, numero, cep) FROM stdin;
1	Centro	santa cruz	240	96015590
2	Centro	brasil	200	96015590
3	centro	brasil	120	96015590
4	Centro	Brasil	200	96015590
\.


--
-- TOC entry 4923 (class 0 OID 16703)
-- Dependencies: 220
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pessoa (pessoa_id, nome, data_nasc, telefone, genero, endereco_id) FROM stdin;
3	Isabella	2005-02-13	54999360899	FEMININO	3
8	João Silva	2010-05-21	54999999	MASCULINO	\N
10	Bernardo	2005-02-13	43985489	MASCULINO	4
\.


--
-- TOC entry 4927 (class 0 OID 16727)
-- Dependencies: 224
-- Data for Name: responsavel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.responsavel (responsavel_id, pessoa_id, parentesco, guardiao_legal) FROM stdin;
\.


--
-- TOC entry 4937 (class 0 OID 0)
-- Dependencies: 221
-- Name: aluno_aluno_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.aluno_aluno_id_seq', 4, true);


--
-- TOC entry 4938 (class 0 OID 0)
-- Dependencies: 217
-- Name: endereco_endereco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.endereco_endereco_id_seq', 4, true);


--
-- TOC entry 4939 (class 0 OID 0)
-- Dependencies: 219
-- Name: pessoa_pessoa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pessoa_pessoa_id_seq', 10, true);


--
-- TOC entry 4940 (class 0 OID 0)
-- Dependencies: 223
-- Name: responsavel_responsavel_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.responsavel_responsavel_id_seq', 1, false);


--
-- TOC entry 4769 (class 2606 OID 16720)
-- Name: aluno aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (aluno_id);


--
-- TOC entry 4765 (class 2606 OID 16672)
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (endereco_id);


--
-- TOC entry 4767 (class 2606 OID 16708)
-- Name: pessoa pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (pessoa_id);


--
-- TOC entry 4771 (class 2606 OID 16732)
-- Name: responsavel responsavel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsavel
    ADD CONSTRAINT responsavel_pkey PRIMARY KEY (responsavel_id);


--
-- TOC entry 4773 (class 2606 OID 16721)
-- Name: aluno aluno_pessoa_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pessoa_id_fkey FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(pessoa_id);


--
-- TOC entry 4772 (class 2606 OID 16709)
-- Name: pessoa pessoa_endereco_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_endereco_id_fkey FOREIGN KEY (endereco_id) REFERENCES public.endereco(endereco_id);


--
-- TOC entry 4774 (class 2606 OID 16733)
-- Name: responsavel responsavel_pessoa_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responsavel
    ADD CONSTRAINT responsavel_pessoa_id_fkey FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(pessoa_id) ON DELETE CASCADE;


-- Completed on 2025-04-26 19:58:28

--
-- PostgreSQL database dump complete
--

