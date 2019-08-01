package com.kobylynskyi.graphql.codegen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;

public class FreeMarkerTemplatesRegistry {

    public static Template typeTemplate;
    public static Template enumTemplate;
    public static Template unionTemplate;
    public static Template operationTemplate;

    static {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setClassLoaderForTemplateLoading(GraphqlCodegen.class.getClassLoader(), "");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);

        try {
            typeTemplate = configuration.getTemplate("templates/javaClassGraphqlType.ftl");
            enumTemplate = configuration.getTemplate("templates/javaClassGraphqlEnum.ftl");
            unionTemplate = configuration.getTemplate("templates/javaClassGraphqlUnion.ftl");
            operationTemplate = configuration.getTemplate("templates/javaClassGraphqlOperation.ftl");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
