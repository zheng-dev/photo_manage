package me.dao;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by zzc on 2017/12/18.
 */
public class BaseDao {
    private static SqlMapClient sqlMapClient = null;

    // 读取配置文件来初始连接
    static {
        try {
            Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
            System.out.println("sqlMapConfig_ok");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();
            System.out.println("read_close_ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected SqlMapClient getSqlMapClient() {
        if (sqlMapClient == null) {
            System.out.println("sqlMapClient_null");
        }
        return sqlMapClient;
    }
}
