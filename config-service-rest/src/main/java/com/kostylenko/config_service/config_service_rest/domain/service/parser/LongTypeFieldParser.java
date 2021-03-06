package com.kostylenko.config_service.config_service_rest.domain.service.parser;

import com.kostylenko.config_service.config_service_rest.domain.service.exception.TypeFieldParseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.kostylenko.config_service.config_service_rest.domain.model.Type.LONG;

@Slf4j
@Component
public class LongTypeFieldParser extends AbstractTypeFieldParser<Long> {

    public LongTypeFieldParser() {
        super(LONG);
    }

    @Override
    public Long parse(Object value) throws TypeFieldParseException {
        try {
            return Long.valueOf(value.toString());
        } catch (Exception e) {
            throw getTypeFieldParseException(value);
        }
    }
}
