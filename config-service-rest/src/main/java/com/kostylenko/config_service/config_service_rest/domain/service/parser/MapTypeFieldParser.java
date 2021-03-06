package com.kostylenko.config_service.config_service_rest.domain.service.parser;

import com.kostylenko.config_service.config_service_rest.domain.service.exception.TypeFieldParseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.kostylenko.config_service.config_service_rest.domain.model.Type.MAP;

@Slf4j
@Component
public class MapTypeFieldParser extends AbstractTypeFieldParser<Map<String, String>> {

    public MapTypeFieldParser() {
        super(MAP);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, String> parse(Object value) throws TypeFieldParseException {
        if (!(value instanceof Map)) {
            throw getTypeFieldParseException(value);
        }
        Map tempMap = (Map) value;
        Map<String, String> result = new HashMap<>();
        tempMap.forEach((key, value1) -> result.put(key.toString(), value1.toString()));
        return result;
    }
}
