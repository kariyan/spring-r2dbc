package com.example.r2dbc.config.converter;

import com.example.r2dbc.common.CodeEnum
import org.springframework.core.convert.converter.Converter
import org.springframework.core.convert.converter.ConverterFactory
import org.springframework.data.convert.ReadingConverter
import org.springframework.util.ObjectUtils

@ReadingConverter
class CodeEnumReadingConverterFactory : ConverterFactory<String, CodeEnum> {
    override fun <T : CodeEnum> getConverter(targetType: Class<T>): Converter<String, T> {
        return CodeEnumReadingConverter(targetType)
    }

    inner class CodeEnumReadingConverter<T : CodeEnum>(private val type: Class<T>) : Converter<String, T> {
        override fun convert(source: String): T {
            if (ObjectUtils.isEmpty(source)) {
                throw IllegalArgumentException("source cannot be blank.")
            }

            if (type.isEnum) {
                for (codeEnum in type.enumConstants) {
                    if (codeEnum.getCode() == source)
                        return codeEnum
                }
                throw NoSuchElementException("Element cannot be found : [$source]")

            } else {
                throw ClassCastException("Target CodeEnum does not implements Enum class.")
            }
        }
    }
}
