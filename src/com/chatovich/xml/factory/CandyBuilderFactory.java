package com.chatovich.xml.factory;

import com.chatovich.xml.builder.AbstractCandyBuilder;
import com.chatovich.xml.builder.DOM_Builder;
import com.chatovich.xml.builder.SAX_Builder;
import com.chatovich.xml.builder.StAX_Builder;
import com.chatovich.xml.type.ParserType;

/**
 * Created by Yultos_ on 17.11.2016
 */
public class CandyBuilderFactory {

    public AbstractCandyBuilder createCandyBuilder(ParserType parserType) {
        switch (parserType) {
            case DOM:
                return new DOM_Builder();
            case STAX:
                return new StAX_Builder();
            case SAX:
                return new SAX_Builder();
            default:
                throw new EnumConstantNotPresentException (parserType.getDeclaringClass(), parserType.name());
        }
    }
}
