package com.zxs.mine.infra.mapper.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

//import org.hibernate.pretty.Formatter;
//import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;

@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class,Integer.class})})
public class SQLStatsInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler= (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();


//        System.out.println("boundSql--->"+sql);
//        System.out.println("美化后--->\n"+ SQLUtils.formatMySql( sql )+"\n");
        System.out.println("执行SQL--->\n"+ new BasicFormatterImpl().format(sql)+"\n");

        ObjectMapper objectMapper = new ObjectMapper();
        //System.out.println (objectMapper.writeValueAsString(boundSql));
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String dialect = properties.getProperty("dialect");
        System.out.println("dialect--->"+dialect);
    }
}