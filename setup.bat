cmd /c "ant -f .setup.xml delete-meta-xml"
cmd /c "mvn eclipse:clean"
cmd /c "mvn -Declipse.workspace=../ eclipse:add-maven-repo"
cmd /c "mvn eclipse:eclipse"
cmd /c "ant -f .setup.xml"
cmd /c "mvn dependency:copy-dependencies"

pause
