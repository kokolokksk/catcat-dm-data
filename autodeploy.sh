git pull
#export PATH=/home/app/maven/apache-maven-3.8.1/bin:$PATH
#mvn -B package --file pom.xml
gradle bootJar
cp build/libs/catcat-dm-data-0.0.1-SNAPSHOT.jar ~/catcat-dm/data
# shellcheck disable=SC2164
cd ~/catcat-dm/data
./stop.sh
./start.sh