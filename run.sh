#!/bin/bash

# Obté el camí del mòdul JavaFX automàticament
FX_PATH=$(find ~/.m2/repository/org/openjfx -name "javafx-*19.0.2.1.jar" -exec dirname {} \; | sort -u | tr '\n' ':' | sed 's/:$//')

if [[ -z "$FX_PATH" ]]; then
    echo "No es pot trobar el mòdul JavaFX al repositori Maven local."
    exit 1
fi

# Opcions comunes per a MAVEN_OPTS
export MAVEN_OPTS="--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED --module-path $FX_PATH --add-modules javafx.controls,javafx.fxml"

# Opcions específiques per a Darwin
if [[ "$OSTYPE" == "darwin"* ]]; then
    export MAVEN_OPTS="$MAVEN_OPTS -Xdock:icon=./target/classes/icons/iconOSX.png"
fi

# Resta de l'script

# Check for the first argument and set it as the main class
mainClass=$1

echo "Setting MAVEN_OPTS to: $MAVEN_OPTS"
echo "Main Class: $mainClass"

# Execute mvn command with the profile and main class as arguments
execArg="-PrunMain -Dexec.mainClass=$mainClass"
echo "Exec args: $execArg"

# Execute mvn command
mvn clean test-compile exec:java $execArg
