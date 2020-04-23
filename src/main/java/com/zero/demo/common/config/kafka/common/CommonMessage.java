package com.zero.demo.common.config.kafka.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringStyle;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

/**
 * @author zero
 * @created on 2020/4/23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonMessage {
 
    private String from;
 
    private String message;
 
    @Override
    public String toString() {
        return reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}