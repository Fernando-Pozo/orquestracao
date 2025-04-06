package com.example.orquestrador.config

import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI

@Configuration
class DynamoDbConfig {

    @Bean
    fun dynamoDbClient(): DynamoDbClient {
        return DynamoDbClient.builder()
            .endpointOverride(URI.create("http://localhost:4566"))
            .credentialsProvider(
                StaticCredentialsProvider.create(
                AwsBasicCredentials.create("test", "test")
            ))
            .region(Region.US_EAST_1)
            .build()
    }

    @Bean
    fun dynamoDbEnhancedClient(dynamoDbClient: DynamoDbClient): DynamoDbEnhancedClient {
        return DynamoDbEnhancedClient.builder()
            .dynamoDbClient(dynamoDbClient)
            .build()
    }

    @Bean
    fun dynamoDbTemplate(dynamoDbEnhancedClient: DynamoDbEnhancedClient): DynamoDbTemplate {
        return DynamoDbTemplate(dynamoDbEnhancedClient)
    }
}