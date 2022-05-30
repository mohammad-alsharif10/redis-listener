package com.example.redistest.entity.redis;

import com.example.redistest.entity.BasicModel;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RedisEntityTest extends BasicModel implements Serializable {


    String firstname;
    String lastname;

}
