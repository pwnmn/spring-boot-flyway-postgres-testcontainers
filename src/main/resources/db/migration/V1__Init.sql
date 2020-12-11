CREATE TABLE things (
	id uuid NOT NULL,
	"name" varchar NOT NULL,
	color varchar NOT NULL,
	CONSTRAINT things_pk PRIMARY KEY (id)
);