package com.hepexta.cfg;

import com.hepexta.mappers.DetailMapper;
import com.hepexta.mappers.MockDetailMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PicCfg {

    @Bean
    DetailMapper detailMapper(){
        return new MockDetailMapper();
    }
}
