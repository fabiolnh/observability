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
Elasticsearch: search engine and analytics (too fast, working with index, scalable, distributed, apirest, website searchs, logging, etc)
Kibana: elasticsearch data visualizer. It is to visualize logs, monitoring, operational intelligence. Integrated with the elasticsearch. aggregate and filter data. dashboards, interative graphics, maps, 
Beats (included in the modern elastic stack. It was not used in the ELK Stack): It is integrated with the elasticstack. it is a data collector. It sends the data to log stash or directly to elasticsearch. It collects logs, metrics, network data, audit data, uptime monitoring

* Logstash: data processor. receive, transform and send data. (collect data in real time from several places). it transforms the data. *The use is being decreased. Rarely it is being used. It was replaced for the Beats
```

Infos:
```
Kibana address: http://localhost:5601/

Heartbeat: verify the uptime of the services
Metricbeat: get the metrics from docker, host, etc.
APM: Traceability
