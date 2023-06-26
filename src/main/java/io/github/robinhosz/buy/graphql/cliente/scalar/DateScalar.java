package io.github.robinhosz.buy.graphql.cliente.scalar;

import graphql.Scalars;
import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.stereotype.Component;
import io.github.robinhosz.buy.utils.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Configuration
public class DateScalar {
    @Bean
    public GraphQLScalarType timestampScalarType() {
        return GraphQLScalarType.newScalar()
                .name("Timestamp")
                .description("Timestamp scalar")
                .coercing(new Coercing() {
                    @Override
                    public String serialize(Object input) {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.ENGLISH);
                        return formatter.format((Date)input);
                    }

                    @Override
                    public Object parseValue(Object o) throws CoercingParseValueException {
                        return o;
                    }

                    @Override
                    public Object parseLiteral(Object o) throws CoercingParseLiteralException {
                        return o.toString();
                    }
                })
                .build();

    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .scalar(timestampScalarType());
    }
    }
