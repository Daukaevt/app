run-dist:
	./build/install/app/bin/app

clean:
	./gradlew clean

build:
	./gradlew clean build

installDist:
	./gradlew clean installDist

install:
	./gradlew clean install
