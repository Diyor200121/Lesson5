package org.example.response;

import lombok.Data;

import java.util.Currency;
@Data
public class Response {
    private Location location;
    private Current current;

}
