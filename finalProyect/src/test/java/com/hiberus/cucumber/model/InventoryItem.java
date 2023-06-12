package com.hiberus.cucumber.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class InventoryItem {
    private String name;
    private String description;
    private String price;
}
