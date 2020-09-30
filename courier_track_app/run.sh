while getopts "m:j:" arg; do
	case $arg in
	m | *)
		mvn install
		mvn spring-boot:run
		;;
	j | * )
		java -jar target/courier_track_app-0.0.1-SNAPSHOT.jar
		;;
	esac
done