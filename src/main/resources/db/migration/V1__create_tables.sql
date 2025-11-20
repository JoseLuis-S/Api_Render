CREATE TABLE panes (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio NUMERIC(10, 2) NOT NULL,
    stock INT,
    tipo_harina VARCHAR(100),
    peso INT
);

CREATE TABLE mantecas (
    id BIGSERIAL PRIMARY KEY,
    tipo_manteca VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio NUMERIC(10, 2) NOT NULL
);

CREATE TABLE bocadillos (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio NUMERIC(10, 2) NOT NULL,
    stock INT,
    pan_id BIGINT,
    CONSTRAINT fk_bocadillo_pan FOREIGN KEY (pan_id) REFERENCES panes(id)
);

CREATE TABLE panes_con_manteca (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    stock INT,
    pan_id BIGINT,
    manteca_id BIGINT,
    CONSTRAINT fk_panconmanteca_pan FOREIGN KEY (pan_id) REFERENCES panes(id),
    CONSTRAINT fk_panconmanteca_manteca FOREIGN KEY (manteca_id) REFERENCES mantecas(id)
);
