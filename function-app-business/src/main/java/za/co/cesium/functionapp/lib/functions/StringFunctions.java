package za.co.cesium.functionapp.lib.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;
import za.co.cesium.functionapp.lib.business.StringProcessor;

import java.util.function.Function;

@Configuration
public class StringFunctions {

    private final StringProcessor stringProcessor;

    public StringFunctions(StringProcessor stringProcessor) {
        this.stringProcessor = stringProcessor;
    }

    @Bean
    public Function<String, String> upperCaseString() {
        return value -> {
            System.out.println("Invoke upperCaseString with input " + value);
            return stringProcessor.toUpper(value);
        };
    }

    @Bean
    public Function<Flux<String>, Flux<String>> upperCaseWithFilter() {
        return flux -> flux
            .filter(this::isNotRude)
            .map(String::toUpperCase);
    }

    private boolean isNotRude(String word) {
        if (word.equalsIgnoreCase("rude")) {
            return false;
        }
        return true;
    }

    @Bean
    public Function<String, String> reverseString() {
        return value -> {
            System.out.println("Invoke reverseString with input " + value);
            return stringProcessor.reverse(value);
        };
//        return stringProcessor::reverse;
    }
}