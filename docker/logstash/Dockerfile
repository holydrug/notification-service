ARG ELASTIC_VERSION

# https://www.docker.elastic.co/
RUN mkdir /usr/share/notification-service-logs

FROM docker.elastic.co/logstash/logstash:${ELASTIC_VERSION}

# Add your logstash plugins setup here
# Example: RUN logstash-plugin install logstash-filter-json
