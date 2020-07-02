package com.xxl.job.admin.core.util;

import static com.xxl.job.admin.core.util.JacksonUtil.writeValueAsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.core.Is;
import org.junit.Test;

public class JacksonUtilTest {

    @Test
    public void shouldWriteValueAsString() {
        //given
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "111");
        map.put("bbb", "222");

        //when
        String json = writeValueAsString(map);

        //then
        assertThat(json, is("{\"aaa\":\"111\",\"bbb\":\"222\"}"));
    }

    @Test
    public void shouldReadValueAsObject() {
        //given
        String jsonString = "{\"aaa\":\"111\",\"bbb\":\"222\"}";

        //when
        Map<String, Object> result = JacksonUtil.readValue(jsonString, Map.class);

        //then
        assertThat(result.get("aaa"), Is.<Object>is("111"));
        assertThat(result.get("bbb"), Is.<Object>is("222"));

    }
}
