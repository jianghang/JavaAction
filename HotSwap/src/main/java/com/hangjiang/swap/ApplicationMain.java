package com.hangjiang.swap;

import com.google.gson.Gson;
import com.hangjiang.bo.SourceCodeEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.tools.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.*;

/**
 * Created by jianghang on 2018/3/20.
 */
public class ApplicationMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        System.out.println(ApplicationMain.class.getResource("/"));
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DatabaseConfig.class);

        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from t_source_code_java t";

        SourceCodeEntity codeEntity = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            SourceCodeEntity entity = new SourceCodeEntity();
            entity.setId(rs.getInt("id"));
            entity.setSourceCode(rs.getString("source_code"));

            return entity;
        });

        System.out.println(new Gson().toJson(codeEntity));

        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        List<String> options = new ArrayList<>();
        options.add("-Xlint:unchecked");

        StandardJavaFileManager manager;
        manager = javaCompiler.getStandardFileManager(null, null, null);

        JavaFileObject javaFileObject = new StringJavaObject("TestDemo",codeEntity.getSourceCode());
        List<JavaFileObject> javaFileObjectList = Arrays.asList(javaFileObject);

        JavaCompiler.CompilationTask task = javaCompiler.getTask(null, manager, null, options, null, javaFileObjectList);
        Boolean result = task.call();
        System.out.println(result);

//        Class<?> cls = null;
//        ClassLoader classLoader = null;
//
//        classLoader = ApplicationMain.class.getClassLoader();
//        cls = classLoader.loadClass("TestDemo");
//        Method method = cls.getDeclaredMethod("echoString",String.class);
//        Object obj = cls.newInstance();
//        String str = (String) method.invoke(obj,"world");
//        System.out.println(str);

        StringBuilder sb = new StringBuilder();
        sb.append("package com.even.test;");
        sb.append("import java.util.Map;\nimport java.text.DecimalFormat;\n");
        sb.append("public class Sum{\n");
        sb.append("private final DecimalFormat df = new DecimalFormat(\"#.#####\");\n");
        sb.append("public Double calculate(Map<String,Double> data){\n");
        sb.append("double d = (30*data.get(\"f1\") + 20*data.get(\"f2\") + 50*data.get(\"f3\"))/100;\n");
        sb.append("return Double.valueOf(df.format(d));}}\n");
        //设置编译参数
        ArrayList<String> ops = new ArrayList<String>();
        ops.add("-Xlint:unchecked");
        //编译代码，返回class
        Class<?> cls = ClassUtils.loadClass("/com/even/test/Sum.java",sb.toString(),"com.even.test.Sum",ops);
        //准备测试数据
        Map<String,Double> data = new HashMap<String,Double>();
        data.put("f1", 10.0);
        data.put("f2", 20.0);
        data.put("f3", 30.0);
        //执行测试方法
        Object resultStr = ClassUtils.invoke(cls, "calculate", new Class[]{Map.class}, new Object[]{data});
        //输出结果
        System.out.println(resultStr);
    }
}

//文本中的Java对象
class StringJavaObject extends SimpleJavaFileObject {
    //源代码
    private String content = "";

    //遵循Java规范的类名及文件
    public StringJavaObject(String _javaFileName, String _content) {
        super(_createStringJavaObjectUri(_javaFileName), Kind.SOURCE);
        content = _content;
    }

    //产生一个URL资源路径
    private static URI _createStringJavaObjectUri(String name) {
        //注意此处没有设置包名
        return URI.create("String:///" + name + Kind.SOURCE.extension);
    }

    //文本文件代码
    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors)
            throws IOException {
        return content;
    }
}
