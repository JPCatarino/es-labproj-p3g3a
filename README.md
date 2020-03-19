# CoinRanking
## Software Engineering Lab Project - 2019/2020

A mainly exploratory springboot app, deployed using docker, which uses the Coin Ranking API to 
show a cryptocurrency rank! 

Developed by Jorge Catarino (@JPCatarino)

# Deploy:
PowerShell:
```powershell
./mvnw clean package -DskipTests; docker-compose up -d
```
Bash:
```bash
./mvnw clean package -DskipTests & docker-compose up -d
```

After a successful deploy, the app will be available on http://localhost:8080/coinRanking-0.0.1-SNAPSHOT

## Notes on deploy:

The CoinRanking app uses the following ports:

	APP - 8080:8080, 4848:4848

	DB - 3306:3306

	KAFKA - 9092:9092

	ZOOKEEPER - 2181:2181

## Issues and other problems
1. Tests must be skipped on compile because maven tries to connect with the database and kafka server.
Even if both containers are running, this is bound to fail on windows OS (where this was developed) cause they can't connect directly
to docker networks.

2. Sometimes, the kafka image will start consuming lots of resources and crash docker. I'm unsure what causes this behaviour!
My suspicion is that it happens when the app is ready before the kafka server.

## User Manual:

1. Go to http://localhost:8080/coinRanking-0.0.1-SNAPSHOT

2. You'll be greeted with a index page where you can select between "Check Rank" and "Check Logs".
	That's pretty much it!
		
It's also possible to publish a message by sending a POST request to http://localhost:8080/coinRanking-0.0.1-SNAPSHOT/kafka/publish
