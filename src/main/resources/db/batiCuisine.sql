CREATE DATABASE batiCuisine;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE projectStatus AS ENUM ('IN_PROGRESS', 'DONE', 'CANCELLED');
CREATE TYPE componentType AS ENUM ('MATERIALS', 'WORKFORCE');
CREATE TYPE projectType AS ENUM ('RENOVATION', 'CONSTRUCTION');

CREATE TABLE Clients (
                         id UUID primary key not null DEFAULT uuid_generate_v4(),
                         name varchar(50),
                         address varchar(250),
                         phoneNumber varchar(20),
                         isProfessional boolean default false
);

CREATE TABLE Projects (
                          id UUID primary key not null DEFAULT uuid_generate_v4(),
                          name varchar(250),
                          profitMargin NUMERIC default null,
                          totalCost NUMERIC default null,
                          surfaceArea NUMERIC default null,
                          type projectType default null,
                          status projectStatus default 'IN_PROGRESS',
                          clientId UUID references Clients(id)
);

CREATE TABLE Quotes (
                        id UUID primary key not null DEFAULT uuid_generate_v4(),
                        projectId UUID references Projects(id),
                        estimatedCost NUMERIC default 0.0,
                        issueDate DATE default current_date,
                        validityDate DATE default null,
                        isAccepted boolean not null default false
);

CREATE TABLE ComponentTypes(
                               id UUID primary key not null DEFAULT uuid_generate_v4(),
                               name varchar(250),
                               type componentType
);
CREATE TABLE Components (
                            id UUID primary key not null DEFAULT uuid_generate_v4(),
                            name varchar(250),
                            type UUID references ComponentTypes(id),
                            vatRate NUMERIC default null,
                            totalPrice NUMERIC default null,
                            projectId UUID references Projects(id)
);

CREATE TABLE Materials(
                          unitCost NUMERIC default null,
                          quantity NUMERIC default null,
                          transportCost NUMERIC default null,
                          qualityCoefficient  NUMERIC default 1.0
) inherits (Components);

CREATE TABLE Workforce(
                          hourlyRate NUMERIC default null,
                          hoursWorked NUMERIC default null,
                          workerProductivity NUMERIC default 1.0
) inherits (Components);
