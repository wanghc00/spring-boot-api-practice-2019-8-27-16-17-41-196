/*
 * Copyright (C), 1992-2019
 * Package com.tw.apistackbase 
 * FileName: CampanyResourceController.java
 * Author:   wang-hc
 * Date:     2019年8月29日 上午12:05:59
 * Description: //模块目的、功能描述      
 * History: //修改记录
 *===============================================================================================
 *   author：          time：                             version：           desc：
 *   wang-hc           2019年8月29日上午12:05:59                     1.0                  
 *===============================================================================================
 */
package com.tw.apistackbase;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 名称：〈一句话功能简述〉<br> 
 * 功能：〈功能详细描述〉<br>
 * 方法：〈方法简述 - 方法描述〉<br>
 * 版本：1.0 <br>
 * 日期：2019年8月29日 <br>
 * 作者：wang-hc <br>
 * 说明：<br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CampanyResourceController {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void shouldReturnStringContains_company001() throws Exception {
        this.mockMvc.perform(get("/companies")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("company001")));
    }
    
    @Test
    public void shouldGetBadRequest() throws Exception {
        this.mockMvc.perform(get("/companies/008")).andDo(print()).andExpect(status().isNotFound());
    }
    
    @Test
    public void shouldGetIdInBody() throws Exception{
        this.mockMvc.perform(get("/companies/001"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is("001")));
    }
    
}
