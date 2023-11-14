package com.playtalk.playtalkapp.domain;

import jakarta.persistence.Converter;

import java.util.Objects;

@Converter
public class StatusTypeConverter implements AttributeConverter<StatusType,String> {
    @Override
    public String convertToDatabaseColumn(StatusType attribute) {//Status Type 의 속성 데이터를 Enum으로 변환하여 데이터베이스에 저장
        if (Objects.isNull(attribute)) {
            return null;
        }
        return attribute.getStatus();
    }

    @Override
    public StatusType convertToEntityAttribute(String dbData) { //dbData에서 불러와 Entity 의 String 값으로 변환.
        if (dbData == null) {
            return null;
        }

        // 여기서는 간단한 예시로 문자열 값과 일치하는 StatusType을 찾습니다.
        for (StatusType statusType : StatusType.values()) {
            if (statusType.getStatus().equals(dbData)) {
                return statusType;
            }
        }

        // 일치하는 값이 없을 경우 예외 처리 또는 기본값을 설정할 수 있습니다.
        throw new IllegalArgumentException("Unknown StatusType: " + dbData);
    }
}
