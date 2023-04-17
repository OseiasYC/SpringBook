-- LABS:
INSERT INTO lab (lami, description, status, desktops, location) 
VALUES 
    ('LAMI 1', 'Laboratório de Micro Informática 1', true, 20, 'B413'), 
    ('LAMI 2', 'Laboratório de Micro Informática 2', true, 20, 'B414'),
    ('LAMI 3', 'Laboratório de Micro Informática 3', true, 20, 'B415'),
    ('LAMI 4', 'Laboratório de Micro Informática 4', true, 20, 'B416'),
    ('LAMI 5', 'Laboratório de Micro Informática 5', true, 20, 'B417'),
    ('LAMI 6', 'Laboratório de Micro Informática 6', true, 20, 'B418'),
    ('LAMI 7', 'Laboratório de Micro Informática 7', true, 20, 'B419'),
    ('LAMI 8', 'Laboratório de Micro Informática 8', true, 20, 'B420'),
    ('LAMI 9', 'Laboratório de Micro Informática 9', true, 20, 'B421'),
    ('LAMI 10', 'Laboratório de Micro Informática 10', true, 20, 'B422'),
    ('LAMI WEX', 'Laboratório WEX Brasil Tech', true, 20, 'B423');

-- PROFESSORS:
INSERT INTO professor (name, login)
VALUES ('Osvaldo Requião Melo', 'osvaldo');
INSERT INTO subject (name, professor_login)
VALUES ('Raciocínio Lógico', 'osvaldo'), ('Compiladores', 'osvaldo'), ('Projeto Final', 'osvaldo');

INSERT INTO professor (name, login)
VALUES ('Fernando Cézar Reis Borges', 'fernando');
INSERT INTO subject (name, professor_login)
VALUES ('Lógica de Prog. e Algoritmos', 'fernando'), ('Arquitetura de Software', 'fernando'), ('Gorvernança de TI', 'fernando');

-- BOOKINGS:
INSERT INTO booking (approved, lab_id, professor_id, subject_id, time_request, time_init, time_final) 
VALUES (false, 1, 2, 5, CURRENT_TIMESTAMP AT TIME ZONE 'UTC','2023-10-20T09:00:00'::timestamp without time zone, '2023-10-20T09:30:00'::timestamp without time zone);

INSERT INTO booking (approved, lab_id, professor_id, subject_id, time_request, time_init, time_final) 
VALUES (false, 1, 2, 6, CURRENT_TIMESTAMP AT TIME ZONE 'UTC','2023-10-20T09:00:00'::timestamp without time zone, '2023-10-20T09:30:00'::timestamp without time zone);

INSERT INTO booking (approved, lab_id, professor_id, subject_id, time_request, time_init, time_final) 
VALUES (true, 11, 1, 3, CURRENT_TIMESTAMP AT TIME ZONE 'UTC','2023-10-20T09:00:00'::timestamp without time zone, '2023-10-20T09:30:00'::timestamp without time zone);