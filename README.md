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

OBS: You can use Elastic Cloud to configure the whole environment using the cloud (GCP, AWS or Azure)
- https://www.elastic.co/pt/cloud/

## Prometheus
- An Open Source Toolkit
- Monitor Metrics to get Insights
- Intelligent Alerts
- Can capture: dimensional data. 
- Powerful queries
- Easy visualization with Grafana
- You do not visualize the data using prometheus, you use other system that manages dashboards
- High mechanism with data compression to not overload the storage
- Simple
- Integration Diversity
- Differently from ElasticStack (that the App has an Agent that send the data to ElasticStack), Prometheus works with pull (through http, /metrics, Prometheus accesses the app and get the information that it needs)
- the /metrics needs to have the format that the prometheus understands (using libs)
- The metrics can be collected from MySQL, NgInx, Linux Server, Kafka, etc. (almost everything) using "Exporters" (the exporters is like an interface that creates the /metrics for these things). There are exporters for several technologies
- Architecture: 
     * Time Series Database (faster than traditional databases), 
     * HttpServer (to extract information from prometheus and use it)
     * Retrieval (receive the information and save into database)
     * It can access the service discovery to get the information of new pods from kubernetes, as an example.
     * Push Gateway: a local that can receive information from apps (ex: in cases that you deploy an application that stays online during 30 minutes and no more than that)
     * AlertManager: it connects to HttpServer from prometheus and configures alerts, like send an email, 
- Metrics:
```
     1) Counter: 
      * Incremental Value (ex: visit number)
      * In case the pod or the system shuts down, prometheus knows the last number and starts to sum it. So, you do not lose count.
     2) Gauge:
      * Values that change in time (ex: memory utilization, users that are online, etc)
     3) Histogram:
      * Measurement is sample-based
      * Can aggregate values
      * Ex: During a time, we can aggregate some information
      * Ex: How many visits you had in X Seconds
     4) Summary:
      * Similar to Histogram. Commonly, Summary is not used. We use Histogram.
      * The difference: the values are calculated in the server, not in the Prometheus.
      * Good to have approximate values. 
      * Ex: Request Duration
```
- PromQL: The "SQL" of Prometheus. The language to query the prometheus. Usually there are autocomplete of these PromQL in Grafana Dashboards
- The target (apps that will get the metrics) configuration stays in "prometheus.yml" file of prometheus
- You can configurate a target of its own prometheus to get the metrics from it (from its HttpServer)
- There is a web interface in prometheus, but not so good to interact. The best way is to use other app, such as Grafana

## Metrics
- cAdvisor: Use it to collect container metrics (https://github.com/google/cadvisor). Remember: Configure it as a prometheus target
- Grafana: use it to build dashboards. There are a lot of dashboards created by the community
- You can configure alarms in Grafana (as an example, you can send a msg to your Telegram)
