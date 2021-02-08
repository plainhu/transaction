import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

/**
 * @author hkt
 * @Title: MainGenerator
 * @ProjectName cloud-orange2
 * @Description: TODO
 * @date 2019/10/29 20:05
 */
public class MainGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //获取项目路径
        String projectPath = System.getProperty("user.dir");
        globalConfig
                //设置生成文件的输出目录
                .setOutputDir(projectPath + "/generator/src/main/java")
                //设置开发人员
                .setAuthor("hkt")
                //是否打开输出目录
                .setOpen(false)
                //实体属性 Swagger2 注解
                //.setSwagger2(false)
                //是否覆盖已有文件
                .setFileOverride(true)
                //是否开启 ActiveRecord 模式
                .setActiveRecord(true)
                //是否开启 BaseResultMap
                .setBaseResultMap(true)
                //是否开启 baseColumnList
                .setBaseColumnList(true)
                //是否在xml中添加二级缓存配置
                .setEnableCache(false);
        autoGenerator.setGlobalConfig(globalConfig);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc      //设置数据库类型
                .setDbType(DbType.MYSQL)
                //设置数据库 schema name
                //.setSchemaName("public");
                .setUrl("jdbc:mysql://192.168.100.100:3306/ts_bank1?characterEncoding=UTF-8&serverTimezone=CTT&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&useSSL=true")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("123456");
        autoGenerator.setDataSource(dsc);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig
                .setParent("com.plainhu")
                .setModuleName(scanner("模块名"))
                .setMapper("mapper")
                .setEntity("po");
        autoGenerator.setPackageInfo(packageConfig);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                //全局大写命名
                .setCapitalMode(true)
                //数据库映射到实体的策略
                .setNaming(NamingStrategy.underline_to_camel)
                //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //是否为lombok模型（默认 false）
                .setEntityLombokModel(true)
                //生成的表
                //.setInclude(scanner("表名，多个英文逗号分割").split(","))
                //驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                //Boolean类型字段是否移除is前缀（默认 false）
                .setEntityBooleanColumnRemoveIsPrefix(true)
                //设置表前缀
                .setTablePrefix("t_");
        autoGenerator.setStrategy(strategyConfig);


        // 自定义配置
/*        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 velocity
        String templatePath = "/templates/converter.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/converter/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        autoGenerator.setCfg(injectionConfig);*/

/*        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
         templateConfig.setEntity("templates/entity2.java");
         templateConfig.setService();
         templateConfig.setController();
         templateConfig.setXml(null);
         autoGenerator.setTemplate(templateConfig);*/

        autoGenerator.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
