FROM jboss/keycloak-adapter-wildfly
MAINTAINER Denis Renning <denis@devtty.de>

ENV LANG de_DE.utf8

ENV JAVA_OPTS -Duser.language=de -Duser.region=DE

ADD store-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
