package com.example.r2dbc.config.converter;

import com.example.r2dbc.common.CodeEnum
import org.springframework.core.GenericTypeResolver
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter

@ReadingConverter
class CodeEnumReadingConverter<E> : Converter<String, E> where E : Enum<E>, E : CodeEnum {
    @Suppress("UNCHECKED_CAST")
    override fun convert(source: String): E? {
        val type = GenericTypeResolver.resolveTypeArgument(
            javaClass,
            CodeEnumReadingConverter::class.java
        ) as Class<E>
        return java.lang.Enum.valueOf(type, source)
    }
}
