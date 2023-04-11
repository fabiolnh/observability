# Observability

Pillars:

```
1) Metrics: (numerical representation) 
      Technical (ex: CPU, pods, etc)
      Business (ex: how many people access some resource, etc)
2) Logs
3) Tracing
```

Elastic Stack:

```
Elasticsearch: search engine and analytics (too fast, working with index, scalable, distributed, apirest, website searches, logging, etc)
Kibana: elasticsearch data visualizer. It is to visualize logs, monitoring, and operational intelligence. Integrated with the elasticsearch. aggregate and filter data. dashboards, interactive graphics, maps, 
Beats (included in the modern elastic stack. It was not used in the ELK Stack): It is integrated with the elastic stack. It is a data collector. It sends the data to log stash or directly to elasticsearch. It collects logs, metrics, network data, audit data, uptime monitoring

* Logstash: data processor. receive, transform and send data. (collect data in real time from several places). it transforms the data. *The use is being decreased. Rarely it is being used. It was replaced for the Beats
```

Infos:
```
Kibana address: http://localhost:5601/

Heartbeat: verify the uptime of the services
Metricbeat: get the metrics from docker, host, etc.
APM: Traceability (from Front-end (using the RUM - 'real user monitoring' - a javascript lib) to all the micro services, including SQL queries, etc). Logs can be included, too.
Filebeat: send logs from the application through a service running in a Docker or in a a DaemonSet in Kubernetes, directly to Elasticsearch
```

Example Log:
```
{
  "message": "...",
  "logger": "com.fabiolnh.api.common.Teste",
  "level": "INFO",
  "context": {
    "path": "/api/v1/teste/abc",
    "method": "POST",
    "port": "8080",
    "serviceName": "core",
    "externalService": "test",
    "spanId": "...",
    "traceId": "..."
  },
  "data": {
    "duration": "0.139s",
    "attrubuteRequestExample": "teste"
  },
  "exception": {
    "name": "io.micronaut.http.client.exceptions.HttpClientResponseException",
    "message": "",
    "stackTrace": "",
   },
  "timestamp": "2022-09-09T18:43:00.768Z"
}
```
