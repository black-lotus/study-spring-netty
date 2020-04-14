package id.dondon.netty.configurations;

import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "id.dondon.netty.repositories")
//@EnableMongoAuditing(auditorAwareRef = "stringAuditorAware")
public class MongoConfiguration {

  private static final String CLIENT_DESCRIPTION = "Dondon Netty Database";

  // Required for blocking MongoTemplate
//  @Bean
//  public MongoClientOptions mongoClientOptions(MongoReactiveProperties mongoReactiveProperties) {
//    return new MongoClientOptions.Builder()
//        .writeConcern(WriteConcern.ACKNOWLEDGED)
//        .connectionsPerHost(mongoReactiveProperties.getConnectionPerHost())
//        .minConnectionsPerHost(mongoReactiveProperties.getMinConnectionsPerHost())
//        .threadsAllowedToBlockForConnectionMultiplier(
//            mongoReactiveProperties.getThreadsAllowedToBlockForConnectionMultiplier())
//        .connectTimeout(mongoReactiveProperties.getConnectTimeout())
//        .maxWaitTime(mongoReactiveProperties.getMaxWaitTime())
//        .socketTimeout(mongoReactiveProperties.getSocketTimeout())
//        .heartbeatConnectTimeout(mongoReactiveProperties.getHeartbeatConnectTimeout())
//        .heartbeatFrequency(mongoReactiveProperties.getHeartbeatFrequency())
//        .heartbeatSocketTimeout(mongoReactiveProperties.getHeartbeatSocketTimeout())
//        .maxConnectionIdleTime(mongoReactiveProperties.getMaxConnectionIdleTime())
//        .maxConnectionLifeTime(mongoReactiveProperties.getMaxConnectionLifeTime())
//        .minHeartbeatFrequency(mongoReactiveProperties.getMinHeartbeatFrequency())
//        .readPreference(ReadPreference.valueOf(mongoReactiveProperties.getReadPreference()))
//        .applicationName(CLIENT_DESCRIPTION)
//        .build();
//  }
//
//  @Bean
//  public ReactiveMongoTemplate reactiveMongoTemplate(
//      ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory, MongoConverter mongoConverter) {
//    return new ReactiveMongoTemplate(reactiveMongoDatabaseFactory, mongoConverter);
//  }
//
//  @Bean
//  public AuditorAware<String> stringAuditorAware() {
//    return () -> Optional.of("system");
//  }
  
}
