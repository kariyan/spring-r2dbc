package com.example.r2dbc.config.converter;

import com.example.r2dbc.common.CodeEnum
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
class CodeEnumWritingConverter<E> : Converter<E, String> where E : Enum<E>, E : CodeEnum {
    override fun convert(source: E): String {
        return source.getCode()
    }
}
