package za.co.cesium.functionapp.lib.business;

import org.springframework.stereotype.Component;

@Component
public class StringProcessor {

    public String toUpper(String input) {
        return input.toUpperCase();
    }

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
