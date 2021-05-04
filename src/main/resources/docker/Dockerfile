FROM postgres
ENV POSTGRES_PASSWORD   // Enter your database password
ENV POSTGRES_DB         // Enter your database name
COPY create_tables.sql insert_data.sql /docker-entrypoint-initdb.d/