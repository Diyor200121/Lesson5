package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Location {
    private String name;
    private String region;
    private String country;
    private String localtime;
    private String tz_id;
}
