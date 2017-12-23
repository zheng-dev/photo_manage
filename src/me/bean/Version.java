package me.bean;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.sql.Date;

/**
 * Created by zzc on 2017/12/14.
 */
public class Version {

    private String version;
    private Date date_time;

    public Version() {

    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


    public String getVersion() {
        return this.version;
    }

    public void setVersion(String id) {
        this.version = id;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }
}
