package ru.blogic.blogicspring.mapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class XMLMapper {

    private XmlMapper xmlMapper;

    public XMLMapper() {
        this.xmlMapper = new XmlMapper();
    }

    public Object unmarshalObject(Resource resource, Class clazz) throws IOException {
        return xmlMapper.readValue(resource.getURL(), clazz);
    }

}
