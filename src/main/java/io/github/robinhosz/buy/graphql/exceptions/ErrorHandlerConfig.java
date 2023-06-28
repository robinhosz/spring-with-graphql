package io.github.robinhosz.buy.graphql.exceptions;

import graphql.servlet.GraphQLErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorHandlerConfig {

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new GraphQLHandler();
    }
}
