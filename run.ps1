# run.ps1

# Change to the directory where the script is located
Set-Location $PSScriptRoot

# Search for JavaFX jars and generate the module path
$FX_PATHS = Get-ChildItem -Path "$env:USERPROFILE\.m2\repository\org\openjfx" -Recurse -Filter "javafx-*19.0.2.1.jar" | ForEach-Object { $_.DirectoryName } | Sort-Object -Unique
$FX_PATH = ($FX_PATHS -join ";")

# Set MAVEN_OPTS environment variable
$env:MAVEN_OPTS="--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED --module-path $FX_PATH --add-modules javafx.controls,javafx.fxml"

# Check for the first argument and set it as the main class
$mainClass = $args[0]

Write-Host "Setting MAVEN_OPTS to: $env:MAVEN_OPTS"
Write-Host "Main Class: $mainClass"

# Execute mvn command with the profile and main class as arguments
$execArg = "-PrunMain -Dexec.mainClass=" + $mainClass
Write-Host "Exec args: $execArg"

mvn clean test-compile exec:java $execArg
