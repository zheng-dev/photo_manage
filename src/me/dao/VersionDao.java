package me.dao;

import me.bean.Version;

/**
 * Created by zzc on 2017/12/14.
 */
public class VersionDao extends BaseDao {
    public Version getVersion() {
        Version v = null;
        try {
            v = (Version) this.getSqlMapClient().queryForObject("getVersion");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }
}
