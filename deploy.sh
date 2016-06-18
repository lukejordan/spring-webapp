#!
export TOMCAT_HOME=~/install/apache-tomcat-8.0.28
export APP_NAME=web-app
export APP_HOME=~/Development/sideproject/spring-webapp

echo "Stop tomcat"
${TOMCAT_HOME}/bin/shutdown.sh

echo "Build Application"
cd ${APP_HOME}/app-parent
mvn clean package

echo "Clean webapp from tomcat webapps"
rm -rf ${TOMCAT_HOME}/webapps/${APP_NAME}*
echo "Clean tomcat logs"
rm -rf ${TOMCAT_HOME}/logs/*

echo "Deploy webapp"
cp target/${APP_NAME}-*.war ${TOMCAT_HOME}/webapps/${APP_NAME}.war

echo "Start tomcat"
${TOMCAT_HOME}/bin/startup.sh
