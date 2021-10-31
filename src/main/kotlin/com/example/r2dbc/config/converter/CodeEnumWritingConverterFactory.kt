package com.example.r2dbc.config.converter;

import com.example.r2dbc.common.CodeEnum
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory
import org.springframework.data.convert.WritingConverter;
import org.springframework.util.ObjectUtils

@WritingConverter
class CodeEnumWritingConverterFactory : ConverterFactory<CodeEnum, CharSequence> {
    override fun <T : CharSequence> getConverter(targetType: Class<T>): Converter<CodeEnum, T> {
        return CodeEnumWritingConverter(targetType)
    }

    inner class CodeEnumWritingConverter<T : CharSequence>(private val type: Class<T>) : Converter<CodeEnum, T> {
        override fun convert(codeEnum: CodeEnum): T {
            if (ObjectUtils.isEmpty(codeEnum)) {
                throw IllegalArgumentException("CodeEnum cannot be null.")
            }

            if (type.isEnum) {
                @Suppress("UNCHECKED_CAST")
                return codeEnum.getCode() as T

            } else {
                throw ClassCastException("Target CodeEnum does not implements Enum class.")
            }
        }
    }
}
