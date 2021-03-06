package com.kostylenko.config_service.config_service_rest.converter.parameter;

import com.kostylenko.common.common_mapper.domain.converter.BaseConverter;
import com.kostylenko.config_service.config_service_rest.domain.model.Parameter;
import com.kostylenko.config_service.config_service_rest.rest.model.ParameterKey;
import org.springframework.stereotype.Component;

@Component
public class ParameterToApiParameterConverter extends BaseConverter<Parameter, com.kostylenko.config_service.config_service_rest.rest.model.Parameter> {

    @Override
    public com.kostylenko.config_service.config_service_rest.rest.model.Parameter convert(Parameter from, com.kostylenko.config_service.config_service_rest.rest.model.Parameter to) {
        to.setParameterKey(mapper.map(from.getParameterKey(), ParameterKey.class));
        to.setValue(from.getValue());
        return to;
    }
}
