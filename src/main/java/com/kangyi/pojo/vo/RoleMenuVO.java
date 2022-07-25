package com.kangyi.pojo.vo;

import java.util.Arrays;

public class RoleMenuVO {
    private Long id;

    private Long[] ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "RoleMenuVO{" +
                "id=" + id +
                ", ids=" + Arrays.toString(ids) +
                '}';
    }
}
