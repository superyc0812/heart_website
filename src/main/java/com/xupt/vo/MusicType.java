package com.xupt.vo;

/**
 * 音乐类型信息
 */
public class MusicType {
    private Integer music_type_id;
    private String music_type_name;
    private Boolean music_type_status;

    public Integer getMusic_type_id() {
        return music_type_id;
    }

    public void setMusic_type_id(Integer music_type_id) {
        this.music_type_id = music_type_id;
    }

    public String getMusic_type_name() {
        return music_type_name;
    }

    public void setMusic_type_name(String music_type_name) {
        this.music_type_name = music_type_name;
    }

    public Boolean getMusic_type_status() {
        return music_type_status;
    }

    public void setMusic_type_status(Boolean music_type_status) {
        this.music_type_status = music_type_status;
    }
}
