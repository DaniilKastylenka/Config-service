package com.kostylenko.config_service.config_service_rest.converter.parameter_key;

import com.kostylenko.common.common_mapper.domain.converter.BaseConverter;
import com.kostylenko.config_service.config_service_rest.domain.model.ParameterKey;
import org.springframework.stereotype.Component;

@Component
public class ParameterKeyToDataParameterKeyConverter extends BaseConverter<ParameterKey, com.kostylenko.config_service.config_service_rest.data.model.ParameterKey> {

    @Override
    public com.kostylenko.config_service.config_service_rest.data.model.ParameterKey convert(ParameterKey from, com.kostylenko.config_service.config_service_rest.data.model.ParameterKey to) {
        to.setAppName(from.getAppName());
        to.setConfigName(from.getConfigName());
        to.setVersion(from.getVersion());
        to.setName(from.getName());
        return to;
    }
}
