package com.kostylenko.config_service.config_service_rest.converter.parameter;

import com.kostylenko.common.common_mapper.domain.converter.BaseConverter;
import com.kostylenko.config_service.config_service_rest.data.entity.Parameter;
import com.kostylenko.config_service.config_service_rest.domain.model.ParameterKey;
import org.springframework.stereotype.Component;

@Component
public class DataParameterToParameterConverter extends BaseConverter<Parameter, com.kostylenko.config_service.config_service_rest.domain.model.Parameter> {

    @Override
    public com.kostylenko.config_service.config_service_rest.domain.model.Parameter convert(Parameter from, com.kostylenko.config_service.config_service_rest.domain.model.Parameter to) {
        to.setId(from.getId());
        to.setParameterKey(mapper.map(from.getParameterKey(), ParameterKey.class));
        to.setValue(from.getValue());
        return to;
    }
}
