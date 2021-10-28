package com.example.r2dbc.config.converter;

import com.example.r2dbc.common.CodeEnum
import org.springframework.core.convert.converter.Converter
import org.springframework.core.convert.converter.ConverterFactory
import org.springframework.data.convert.ReadingConverter
import org.springframework.util.ObjectUtils

@ReadingConverter
class CodeEnumReadingConverterFactory : ConverterFactory<String, Enum<*>> {
    override fun <T : Enum<*>> getConverter(targetType: Class<T>): Converter<String, T> {
        return CodeEnumReadingConverter(targetType)
    }

    inner class CodeEnumReadingConverter<T : Enum<*>>(private val type: Class<T>) : Converter<String, T> {
        override fun convert(source: String): T {
            if (ObjectUtils.isEmpty(source)) {
                throw IllegalArgumentException("source cannot be blank.")
            }

            if (CodeEnum::class.java.isAssignableFrom(type)) {
                for (codeEnum in type.enumConstants) {
                    if ((codeEnum as CodeEnum).getCode() == source)
                        return codeEnum
                }
                throw NoSuchElementException()
            } else {
                return java.lang.Enum.valueOf(type, source.trim())
            }
        }
    }
}
