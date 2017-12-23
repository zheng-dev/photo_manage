package me.dao;

import me.bean.PhotoInfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by zzc on 2017/12/18.
 */
public class PhotoInfoDao extends BaseDao {

    public List<PhotoInfo> getRows(Map args) {
        List<PhotoInfo> v = null;
        try {
            v = this.getSqlMapClient().queryForList("selPhotoInfo", args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public boolean add(PhotoInfo p) {
        boolean ok = true;
        try {
            this.getSqlMapClient().insert("insPhotoInfo", p);
        } catch (SQLException e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }
}
