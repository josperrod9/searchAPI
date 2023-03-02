package co.empathy.academy.searchAPI.repositories;

import co.empathy.academy.searchAPI.configuration.ElasticSearchConfig;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class ElasticLowClientImpl implements ElasticLowClient {

    private final ElasticSearchConfig searchConfig;

    public ElasticLowClientImpl(ElasticSearchConfig searchConfig) {
        this.searchConfig = searchConfig;
    }

    /**
     * Makes a petition to elastic search that calls to HealthResponse class which contains cluster name
     *
     * @return elasticsearch information
     */
    @Override
    public String getClusterName() throws IOException {
        return searchConfig.getElasticSearchClient().cluster().health().clusterName();
    }
}
