package com.br.config;

import com.datastax.driver.core.Cluster;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClusterScyllaConfig {

    public Cluster buildCluster() {
        return Cluster.builder()
                .withoutJMXReporting()
                .withClusterName("myCluster")
                .addContactPoint("0.0.0.0")
                .build();
    }
}
