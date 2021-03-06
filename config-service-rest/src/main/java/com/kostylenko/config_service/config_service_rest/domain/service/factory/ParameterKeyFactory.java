package com.kostylenko.config_service.config_service_rest.domain.service.factory;

import com.kostylenko.common.common_http.exception.BadRequestApiException;
import com.kostylenko.common.common_mapper.domain.mapper.Mapper;
import com.kostylenko.config_service.config_service_rest.domain.model.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.kostylenko.config_service.config_service_rest.util.Constant.ExceptionMessages.KEY_VALUE_CANNOT_BE_NULL;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@Slf4j
@Component
@AllArgsConstructor
public class ParameterKeyFactory {

    private Mapper mapper;

    public ParameterKey buildParameterKey(Config config, Parameter parameter) {
        ConfigKey configKey = config.getConfigKey();
        ParameterKey parameterKey = mapper.map(configKey, ParameterKey.class);

        Map<String, Object> value = parameter.getValue();
        Meta meta = config.getMeta();
        List<String> keyValues = new ArrayList<>();
        List<Field> keyFields = meta.getFields().stream().filter(Field::isKey).sorted(Comparator.comparingInt(Field::getIndex)).collect(toList());
        keyFields.forEach(keyField -> {
            Object keyFieldValue = value.get(keyField.getName());
            if (isNull(keyFieldValue)) {
                log.warn("Key value {} cannot be null", keyField.getName());
                throw new BadRequestApiException(KEY_VALUE_CANNOT_BE_NULL);
            }
            keyValues.add(keyFieldValue.toString());
        });
        parameterKey.setName(keyValues.stream().collect(Collectors.joining(meta.getKeyDelimiter())));
        return parameterKey;
    }
}
