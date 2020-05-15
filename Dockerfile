FROM postgres
ENV POSTGRES_USER players
ENV POSTGRES_PASSWORD players
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432