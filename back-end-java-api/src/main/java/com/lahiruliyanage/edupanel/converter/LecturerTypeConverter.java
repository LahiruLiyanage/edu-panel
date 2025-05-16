package com.lahiruliyanage.edupanel.converter;

import com.lahiruliyanage.edupanel.tuil.LecturerType;
import org.springframework.core.convert.converter.Converter;

public class LecturerTypeConverter implements Converter<String, LecturerType> {

    @Override
    public LecturerType convert(String source) {
        for (LecturerType lecturerType : LecturerType.values()) {
            if (lecturerType.getType().equalsIgnoreCase(source)) {
                return lecturerType;
            }
        }
        return null;
    }
}
