run:
	docker-compose --env-file .env up -d
build:
	docker-compose --env-file .env up -d --no-deps --build