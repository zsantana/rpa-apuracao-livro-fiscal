FROM azul/zulu-openjdk:11.0.9

ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'

COPY --chown=185 target/quarkus-app/lib/ /deployments/lib/
COPY --chown=185 target/quarkus-app/*.jar /deployments/
COPY --chown=185 target/quarkus-app/app/ /deployments/app/
COPY --chown=185 target/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 8093
USER 185

ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"

ENTRYPOINT ["java", "-jar", "/deployments/quarkus-run.jar"]


#FROM registry.access.redhat.com/ubi8/ubi-minimal:8.5
#WORKDIR /work/
#RUN chown 1001 /work \
#    && chmod "g+rwX" /work \
#    && chown 1001:root /work
#COPY --chown=1001:root target/*-runner /work/application

#EXPOSE 8093
#USER 1001

#CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]